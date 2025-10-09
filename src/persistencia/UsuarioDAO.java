package persistencia;

import entidades.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(usuario);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Usuario buscarPorEmailESenha(String email, String senha) {
    Session session = null;
    try {
        session = HibernateUtil.getSession();
        String hql = "FROM Usuario u WHERE u.email = :email AND u.senha = :senha";
        Query query = session.createQuery(hql); // <- sem tipo genérico
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        return (Usuario) query.uniqueResult(); // cast necessário
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    }
}


