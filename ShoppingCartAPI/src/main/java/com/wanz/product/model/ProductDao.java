package com.wanz.product.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    DAO -- Data access object
    专门用来处理数据库读取,Product相关的数据访问的逻辑！

    ORM会帮我实现这个接口，也就是实现其中的操作！（生成SQL访问语句，执行SQL语句，转换返回结果到JAVA对象）
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

    // 根据ORM的命名惯例，声明操作方法
    Product getById(int id);

    List<Product> findAll();

    Product save(Product product);

}


/*
@Component
public class ProductDao {
    private Statement statement;

    public ProductDao(Statement statement) {
        this.statement = statement;

        // 测试代码
        try {
            statement.executeUpdate("CREATE table IF NOT exists product(id int primary key, name String, description String, price double)");
            ResultSet rs = statement.executeQuery("SELECT * FROM 'product'");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to query product from DB.");
        }
    }

    public List<Product> list() {
        List<Product> listProduct= new ArrayList<Product>();
        try {
            System.out.println("test0, try to list products from database.");

            String query = "SELECT * FROM product";
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                listProduct.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price")));
            }
            return listProduct;
        } catch (SQLException e) {
            System.out.println("Failed to list products from database.");
        }
        return null;
    }

    public Product get(int id) {
        try {
            // 构造SQL查询语句，然后执行
            System.out.println("test1, try to get product from database.");

            String query = "SELECT * FROM product WHERE id = " + id;
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);

            // 根据SQL查询的结果，构造Product对象，并返回
            if (rs.next()) {
                System.out.println("find one product.");
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price")
                );
            } else return null;
        } catch(SQLException e) {
            System.out.println("Failed to get product from database.");
        }
        return null;
    }

    public Product create(CreateProductRequest createProductRequest) {
        try {
            System.out.println("test2, try to add product into database.");

            // 注意不要漏掉' 等数据库中的字符串标识符
            String query = "INSERT into product (id, name, description, price) values ("
                    + createProductRequest.getId() + ","
                    + "'" + createProductRequest.getName() + "',"
                    + "'" + createProductRequest.getDescription() + "',"
                    + createProductRequest.getPrice() + ")";
            //输出语句，出问题时方便检查错误
            System.out.println(query);
            statement.executeUpdate(query);
            System.out.println("add a product");
            return new Product(createProductRequest.getId(),createProductRequest.getName(),createProductRequest.getDescription(),createProductRequest.getPrice());
        } catch (SQLException e) {
            System.out.println("Failed to add product from DB.");
        }
        return null;
    }

    public Product update(int id, UpdateProductRequest updateProductRequest) {
        try {
            System.out.println("test3, try to update product in database.");

            String query = "UPDATE product set name = '" + updateProductRequest.getName() + "'," +
                    "description = '" + updateProductRequest.getDescription() + "'," +
                    "price = " + updateProductRequest.getPrice() +
                    " WHERE id = " + id;
            System.out.println(query);
            statement.executeUpdate(query);
            System.out.println("update a product");
            return new Product(id, updateProductRequest.getName(), updateProductRequest.getDescription(), updateProductRequest.getPrice());
        } catch (SQLException e) {
            System.out.println("Failed to update product in database.");
        }
        return null;
    }

    public void delete(int id) {
        try {
            System.out.println("test4, try to delete a product from database.");

            String query = "DELETE from product WHERE id = " + id;
            System.out.println(query);
            statement.executeUpdate(query);
            System.out.println("delete a product");
        } catch (SQLException e) {
            System.out.println("Failed to delete a product from database.");
        }
    }
}


*/
