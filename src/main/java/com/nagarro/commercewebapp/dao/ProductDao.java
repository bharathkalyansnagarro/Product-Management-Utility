package com.nagarro.commercewebapp.dao;

import com.nagarro.commercewebapp.models.Product;
import com.nagarro.commercewebapp.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ProductDao {
    private final SessionFactory sessionFactory;

    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean saveProduct(Product product) {
        boolean flag = false;

        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(product);
            flag = true;
            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;
    }


    public void deleteProduct(int productId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Product where id=:productId");
        query.setParameter("productId", productId);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Product");
        List<Product> result = query.list();
        session.close();
        return result;
    }

    public Product getProductById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Product where id=:productId");
        query.setParameter("productId", id);
        Product product = (Product) query.uniqueResult();
        transaction.commit();
        session.close();
        return product;
    }

    public void updateProduct(String id, String title, int quantity, String size, String imgUrl) {
        Session session = sessionFactory.openSession();

        try {
            // Check if product exists in the database
            if (getProductById(Integer.parseInt(id)) != null) {
                // Create updated product object
                Product product = session.get(Product.class, Integer.parseInt(id));
                product.setTitle(title);
                product.setQuantity(quantity);
                product.setSize(size);
                product.setImage(imgUrl);
//                product.setUser(user);

                // Start a transaction if not yet started
                if (!session.getTransaction().isActive())
                    session.getTransaction().begin();
                // Update the product details
                session.update(product);
                // Commit the transaction
                session.getTransaction().commit();
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
