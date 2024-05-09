package acme;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.common.runtime.AbstractJpaOperations;
import io.quarkus.hibernate.orm.panache.runtime.AdditionalJpaOperations;
import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;
import io.quarkus.spring.data.runtime.RepositorySupport;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// $VF: synthetic class
@ApplicationScoped
public class AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl implements AuthorsRepository {
   private final Class entityClass;

   public AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl() {
      ClassLoader var1 = Thread.currentThread().getContextClassLoader();
      Class var2 = Class.forName("acme.Author", false, var1);
      this.entityClass = var2;
   }

   @Transactional
   public Author save(Author var1) {
      if (var1.getId() != null) {
         Class var2 = this.entityClass;
         return (Author)((AbstractJpaOperations)JpaOperations.INSTANCE).getEntityManager(var2).merge(var1);
      } else {
         ((AbstractJpaOperations)JpaOperations.INSTANCE).persist(var1);
         return var1;
      }
   }

   public Object save(Object var1) {
      Author var2 = (Author)var1;
      return this.save(var2);
   }

   @Transactional
   public <S extends Author> List<S> saveAll(Iterable<S> var1) {
      ArrayList var4 = new ArrayList();

      for(Object var3 : var1) {
         Author var5 = this.save((Author)var3);
         var4.add(var5);
      }

      return var4;
   }

   public Iterable saveAll(Iterable var1) {
      return this.saveAll(var1);
   }

   public Optional<Author> findById(Long var1) {
      JpaOperations var2 = JpaOperations.INSTANCE;
      Class var3 = this.entityClass;
      return Optional.ofNullable(((AbstractJpaOperations)var2).findById(var3, var1));
   }

   public Optional findById(Object var1) {
      Long var2 = (Long)var1;
      return this.findById(var2);
   }

   public boolean existsById(Long var1) {
      return this.findById(var1).isPresent();
   }

   public boolean existsById(Object var1) {
      Long var2 = (Long)var1;
      return this.existsById(var2);
   }

   public List<Author> findAll() {
      JpaOperations var1 = JpaOperations.INSTANCE;
      Class var2 = this.entityClass;
      return ((PanacheQuery)((AbstractJpaOperations)var1).findAll(var2)).list();
   }

   public Iterable findAll() {
      return this.findAll();
   }

   public List<Author> findAllById(Iterable<Long> var1) {
      Class var2 = this.entityClass;
      return RepositorySupport.findByIds((AbstractJpaOperations)JpaOperations.INSTANCE, var2, "id", var1);
   }

   public Iterable findAllById(Iterable var1) {
      return this.findAllById(var1);
   }

   public long count() {
      JpaOperations var1 = JpaOperations.INSTANCE;
      Class var2 = this.entityClass;
      return ((AbstractJpaOperations)var1).count(var2);
   }

   @Transactional
   public void deleteById(Long var1) {
      Class var2 = this.entityClass;
      if (!((AbstractJpaOperations)JpaOperations.INSTANCE).deleteById(var2, var1)) {
         String var3 = var1.toString();
         Object[] var4 = new Object[]{var3};
         String var5 = String.format("No entity acme.Author with id %s exists", var4);
         throw (Throwable)(new IllegalArgumentException(var5));
      }
   }

   public void deleteById(Object var1) {
      Long var2 = (Long)var1;
      this.deleteById(var2);
   }

   @Transactional
   public void delete(Author var1) {
      ((AbstractJpaOperations)JpaOperations.INSTANCE).delete(var1);
   }

   public void delete(Object var1) {
      Author var2 = (Author)var1;
      this.delete(var2);
   }

   @Transactional
   public void deleteAll(Iterable<? extends Author> var1) {
      RepositorySupport.deleteAll((AbstractJpaOperations)JpaOperations.INSTANCE, var1);
   }

   @Transactional
   public void deleteAll() {
      JpaOperations var1 = JpaOperations.INSTANCE;
      Class var2 = this.entityClass;
      AdditionalJpaOperations.deleteAllWithCascade((AbstractJpaOperations)var1, var2);
   }
}
