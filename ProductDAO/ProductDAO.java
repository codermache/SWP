/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.FeedBack;
import model.Product;
import model.Product_Package;
import model.Service;
import model.User;

/**
 *
 * @author T495
 */
public class ProductDAO extends DBContext {
    
    public Product rowMapperProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("unit_in_stock"),
                new User(rs.getString("create_By")),
                rs.getDate("update_At"),
                rs.getDate("create_At"),
                rs.getInt("sold"),
                rs.getString("image_product"));
    }
    
    public Product_Package rowMapperProductPackage(ResultSet rs) throws SQLException {
        Product_Package product_Package = new Product_Package();
        product_Package.setProductPackageName(rs.getNString("name"));
        product_Package.setProductPackagePrice(rs.getInt("price"));
        product_Package.setCreateBy(getUserSellProduct(rs.getString("create_By")));
        product_Package.setCreateAt(rs.getDate("create_At"));
        product_Package.setUpdateAt(rs.getDate("update_At"));
        return product_Package;
    }
    
    public int getTotalProductOfService(int serviceId) {
        
        String sql = "select count(product_id) as total from service_product S where service_id = ?";
        
        try {
            PreparedStatement psm = connection.prepareStatement(sql);
            psm.setInt(1, serviceId);
            ResultSet rs = psm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
        }
        return 0;
    }
    
    public List<Product> getProductInPageService(int numPage, int sizePage, int serviceId) {
        
        String sql = "select * from Products as p\n"
                + "                     join service_product as sp on sp.product_id = p.id\n"
                + "                     where sp.service_id = ?\n"
                + "                     limit ? offset ? ;";
        List<Product> products = new ArrayList<>();
        // tỏng số sản phẩm cho 1 dịch vụ 
        int totalproduct = getTotalProductOfService(serviceId);
        // tỏng só trang
        int totalPage = totalproduct / sizePage;
        if (totalproduct % sizePage != 0) {
            totalPage += 1;
        }
        //numPage vị trí trang cần lấy sản phẩm
        if (numPage >= 1 && numPage <= totalPage) {
            
            try {
                PreparedStatement psm = connection.prepareStatement(sql);
                psm.setInt(1, serviceId);
                psm.setInt(2, sizePage);
                psm.setInt(3, (numPage - 1) * sizePage);
                ResultSet rs = psm.executeQuery();
                while (rs.next()) {
                    Product p = rowMapperProduct(rs);
                    p.setProduct_Packages(getListPackages(p.getProductId()));
                    products.add(p);
                }
                
            } catch (SQLException e) {
                return null;
            }
        }
        return products;
    }
    
    public int getTotalPageProductService(int serviceID, int sizePage) {
        int totalProduct = getTotalProductOfService(serviceID);
        int nPage = totalProduct / sizePage;
        if (totalProduct % sizePage != 0) {
            nPage++;
        }
        return nPage;
    }

    // get new product
      public List<Product> getNewProducts() {
        String sql = "SELECT * FROM products\n"
                + " ORDER BY create_at DESC\n"
                + " LIMIT 8";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement psm = connection.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                Product p = rowMapperProduct(rs);
                p.setProduct_Packages(getListPackages(p.getProductId()));
                products.add(p);
            }

        } catch (SQLException e) {
        }
        return products;
    }

    
    public List<Product> getTopSelling() {
        String sql = "select * from products\n"
                + "order by sold desc \n"
                + "limit 8 ";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Product p = rowMapperProduct(rs);
                p.setProduct_Packages(getListPackages(p.getProductId()));
                products.add(p);
                
            }
            
        } catch (SQLException e) {
        }
        return products;
    }
    
    public List<Product_Package> getListPackages(int product_id) {
        String sql = "select * from product_package where product_id = ? \n"
                + "order by price desc";
        List<Product_Package> product_Packages = new ArrayList<>();
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setInt(1, product_id);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                product_Packages.add(rowMapperProductPackage(rs));
            }
            
        } catch (SQLException e) {
        }
        return product_Packages;
    }
    
    public List<Product> searchProducts(String searchTerm, int service_id, String sortOption) {
        PreparedStatement stm;
        ResultSet rs;
        List<Product> list = new ArrayList<>();
        try {
            String query = "SELECT p.* FROM products p";
            
            if (service_id > 0) {
                query += " JOIN Service_Product sp ON p.id = sp.product_id "
                        + " JOIN Service s ON sp.service_id = s.id "
                        + " WHERE p.name LIKE ? AND s.id = ?";
            } else {
                query += " WHERE p.name LIKE ?";
            }
            if ("name_asc".equals(sortOption)) {
                query += " ORDER BY p.name ASC";
            } else if ("name_desc".equals(sortOption)) {
                query += " ORDER BY p.name DESC";
            } else if ("sold_asc".equals(sortOption)) {
                query += " ORDER BY p.sold ASC";
            } else if ("sold_desc".equals(sortOption)) {
                query += " ORDER BY p.sold DESC";
            }
            
            stm = connection.prepareStatement(query);
            stm.setString(1, "%" + searchTerm + "%");
            
            if (service_id > 0) {
                stm.setInt(2, service_id);
            }
            
            rs = stm.executeQuery();
            
            while (rs.next()) {
                Product c = new Product();
                c.setProductId(rs.getInt("id"));
                c.setProductName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                c.setUnitInStock(rs.getInt("unit_in_stock"));
                c.setCreatedBy(getUserSellProduct(rs.getString("create_by")));
                c.setUpdatedAt(rs.getDate("update_at"));
                c.setCreatedAt(rs.getDate("create_at"));
                c.setSold(rs.getInt("sold"));
                c.setImageProduct(rs.getString("image"));
                
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // SUA  LAI
    public User getUserSellProduct(String user) {
        String sql = "select * from users where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        user,
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Product getProductById(int id) {
        
        String sql = "select * from products where id = ? ";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Product(id,
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("unit_in_stock"),
                        getUserById(rs.getInt("create_by")),
                        rs.getDate("update_at"),
                        rs.getDate("create_at"),
                        rs.getInt("sold"),
                        rs.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Service> getServiceByProduct(Product p) {
        List<Service> list = new ArrayList<>();
        
        String sql = "select s.* from Services s\n"
                + "	join Service_Product sp on s.id = sp.service_id\n"
                + "    where sp.product_id = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getProductId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Service(rs.getInt(1), rs.getString(2), rs.getDate(3), getUserSellProduct(rs.getString(4)), rs.getDate(5)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product_Package> getListPackages(Product p) {
        List<Product_Package> list = new ArrayList<>();
        String sql = "select * from product_package where product_id = ?"
                + " order by price";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product_Package(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        getAccById(rs.getInt(5)),
                        rs.getDate(6),
                        p));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<FeedBack> getFeedbacksOfPd(Product p) {
        List<FeedBack> list = new ArrayList<>();
        String sql = "select * from feedbacks where product_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getProductId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new FeedBack(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        getAccById(rs.getInt(5)),
                        p,
                        rs.getDate(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public FeedBack getFeedbackById(int id) {
        String sql = "select * from feedbacks where id=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new FeedBack(id,
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        getAccById(rs.getInt(5)),
                        getProductById(rs.getInt(6)),
                        rs.getDate(7));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public User getAccById(int id) {
        String sql = "select * from users where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public User getUserById(int userId) {
        String sql = "select * from users where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("facebook_link"),
                        rs.getTimestamp("create_at"),
                        rs.getString("image"),
                        rs.getInt("role"),
                        rs.getInt("active"),
                        rs.getInt("wallet"));
                return u;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    

    public List<Product> getProductsByUsername(String username) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.id, p.name, p.description, p.unit_in_stock, p.create_by, p.update_at, p.create_at, p.sold, p.image "
                + "FROM products p "
                + "JOIN users u ON p.create_by = u.id "
                + "WHERE u.username = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Product c = new Product();
                c.setProductId(rs.getInt("id"));
                c.setProductName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                c.setUnitInStock(rs.getInt("unit_in_stock"));
                c.setCreatedBy(getUserSellProduct(rs.getString("create_by")));
                c.setUpdatedAt(rs.getDate("update_at"));
                c.setCreatedAt(rs.getDate("create_at"));
                c.setSold(rs.getInt("sold"));
                c.setImageProduct(rs.getString("image"));
                
                list.add(c);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        getAccById(rs.getInt(5)),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getString(9),
                        getListPackages(getProductById(rs.getInt(1)))));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> getAllProductSellByUser(int userId) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products\n"
                + "where create_by = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = getUserById(rs.getInt("create_by"));
                Product p = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("unit_in_stock"),
                        u,
                        rs.getDate("update_at"),
                        rs.getDate("create_at"),
                        rs.getInt("sold"),
                        rs.getString("image")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Product> getProductSellByUserPerPage(List<Product> list, int start, int end) {
        List<Product> listPerPage = new ArrayList<>();
        for (int i = start; i < end; i++) {
            listPerPage.add(list.get(i));
        }
        return listPerPage;
    }
    
    public List<Service> getServicesCreateByUser(int uid) {
        List<Service> list = new ArrayList<>();
        User u = getUserById(uid);
        String sql = "select distinct s.id, s.name, s.create_at, s.create_by, s.update_at\n"
                + "from service_product as sp\n"
                + "join products as p on sp.product_id = p.id\n"
                + "join services as s on sp.service_id = s.id\n"
                + "where p.create_by = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Service s = new Service(rs.getInt("id"), rs.getString("name"), rs.getDate("create_at"), u, rs.getDate("update_at"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Product> getProductHotSelling(int uid) {
        List<Product> list = new ArrayList<>();
        User u = getUserById(uid);
        String sql = "select * from products\n"
                + "where create_by = ?\n"
                + "order by sold desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("unit_in_stock"),
                        u,
                        rs.getDate("update_at"),
                        rs.getDate("create_at"),
                        rs.getInt("sold"),
                        rs.getString("image")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Product> getProductHotSellingWithFilter(List<Product> product, int uid) {
        List<Product> list = new ArrayList<>();
        User u = getUserById(uid);
        String sql = "select * from products as p\n"
                + "where 1 = 1\n";
        if (product != null) {
            sql += "and p.id in (";
            for (Product i : product) {
                sql += i.getId() + ", ";
            }
            if (sql.endsWith(", ")) {
                sql = sql.substring(0, sql.length() - 2);
            }
            sql += ")\n";
        }
        sql += "sold";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("unit_in_stock"),
                        u,
                        rs.getDate("update_at"),
                        rs.getDate("create_at"),
                        rs.getInt("sold"),
                        rs.getString("image")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Product> filterProduct(int uid, String[] productServices) {
        List<Product> list = new ArrayList<>();
        User u = getUserById(uid);
        String sql = "select distinct p.id, p.name, p.description, p.unit_in_stock, p.create_by, p.update_at, p.create_at, p.sold, p.image\n"
                + "from products as p\n"
                + "join service_product as sp\n"
                + "on p.id = sp.product_id\n"
                + "where 1 = 1\n"
                + "and p.create_by = " + uid + "\n";
        if (productServices != null) {
            sql += "and sp.service_id in (";
            for (int i = 0; i < productServices.length; i++) {
                sql += productServices[i] + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")\n";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("unit_in_stock"),
                        u,
                        rs.getDate("update_at"),
                        rs.getDate("create_at"),
                        rs.getInt("sold"),
                        rs.getString("image")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Display services of product
    public List<String> displayServices(int uid) {
        List<String> list = new ArrayList<>();
        String sql = "select distinct s.name\n"
                + "from service_product as sp\n"
                + "join products as p on sp.product_id = p.id\n"
                + "join services as s on sp.service_id = s.id\n"
                + "where p.create_by = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, uid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String service = rs.getString("name");
                list.add(service);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<FeedBack> getAllFeedBackOfSeller(List<Product> product) {
        List<FeedBack> list = new ArrayList<>();
        String sql = "select * from feedbacks as f\n"
                + "join products as p on f.product_id = p.id\n"
                + "where 1 = 1\n";
        if (product != null) {
            sql += "and p.id in (";
            for (Product i : product) {
                sql += i.getId() + ",";
            }
            sql = sql.substring(0, sql.length() - 1);
            sql += ")\n";
        }
        sql += "order by f.create_at desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                FeedBack f = new FeedBack(rs.getInt("id"), rs.getInt("rating"), rs.getString("comment"), rs.getDate("create_at"), getUserById(rs.getInt("create_by")), getProductById(rs.getInt("product_id")));
                list.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<FeedBack> getAllFeedBackOfSellerByFilter(List<Product> product, int rating) {
        List<FeedBack> list = new ArrayList<>();
        String sql = "select * from feedbacks as f\n"
                + "join products as p on f.product_id = p.id\n"
                + "where 1 = 1\n";
        if (product != null) {
            sql += "and p.id in (";
            for (Product i : product) {
                sql += i.getId() + ",";
            }
            sql = sql.substring(0, sql.length() - 1);
            sql += ")\n";
        }
        if (rating != 0) {
            sql += "and rating = " + rating + "\n";
        }
        sql += "order by f.create_at desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                FeedBack f = new FeedBack(rs.getInt("id"), rs.getInt("rating"), rs.getString("comment"), rs.getDate("create_at"), getUserById(rs.getInt("create_by")), getProductById(rs.getInt("product_id")));
                list.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

public boolean insertProduct(Product product) {
        boolean rowInserted = false;
        String sql = "INSERT INTO products (name, description, unit_in_stock, create_by, sold, image) VALUES (?, ?, ?, ?, ?, ?)";

        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getDescription());
            statement.setInt(3, product.getUnitInStock());
            statement.setInt(4, product.getCreatedBy().getId());
            statement.setInt(5, product.getSold());
            statement.setString(6, product.getImageProduct());

            rowInserted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging the exception instead
        }
        return rowInserted;

    }
    public void DeleteProduct(int id){
        String sql ="DELETE FROM products WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<Product> ListProduct(){
        String sql ="SELECT * FROM products";
        List<Product> products = new ArrayList<>();
        ResultSet rs;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            rs = statement.executeQuery();

            // Iterate through the result set and create Product objects
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setUnitInStock(rs.getInt("unit_in_stock"));
                User createBy = new User(); // Instantiate a User object
                createBy.setId(rs.getInt("create_by")); // Set the user ID
                product.setCreatedBy(createBy);
                product.setUpdatedAt(rs.getDate("update_at"));
                product.setCreatedAt(rs.getDate("create_at"));
                product.setSold(rs.getInt("sold"));
                product.setImageProduct(rs.getString("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return products;
    }
    
    public List<FeedBack> getFeedbackStorePerPage(List<FeedBack> list, int start, int end) {
        List<FeedBack> listPerPage = new ArrayList<>();
        for (int i = start; i < end; i++) {
            listPerPage.add(list.get(i));
        }
        return listPerPage;
    }
    
    public List<Product_Package> getAllProductPackage() {
        List<Product_Package> list = new ArrayList<>();
        String sql = "select * from product_package";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product_Package(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        getAccById(rs.getInt(5)),
                        rs.getDate(6),
                        getProductById(rs.getInt(7))));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
