package acme;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.common.runtime.AbstractJpaOperations;
import io.quarkus.hibernate.orm.panache.runtime.AdditionalJpaOperations;
import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;
import io.quarkus.spring.data.runtime.FunctionalityNotImplemented;
import io.quarkus.spring.data.runtime.RepositorySupport;
import io.quarkus.spring.data.runtime.TypesConverter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

// $VF: synthetic class
@ApplicationScoped
public class CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl implements CalendarRepository {
   private final Class entityClass;

   public CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl() {
      ClassLoader var1 = Thread.currentThread().getContextClassLoader();
      Class var2 = Class.forName("acme.Calendar", false, var1);
      this.entityClass = var2;
   }

   @Transactional
   public Calendar save(Calendar var1) {
      if (var1.getId() != null) {
         Class var2 = this.entityClass;
         return (Calendar)((AbstractJpaOperations)JpaOperations.INSTANCE).getEntityManager(var2).merge(var1);
      } else {
         ((AbstractJpaOperations)JpaOperations.INSTANCE).persist(var1);
         return var1;
      }
   }

   public Object save(Object var1) {
      Calendar var2 = (Calendar)var1;
      return this.save(var2);
   }

   @Transactional
   public Calendar saveAndFlush(Calendar var1) {
      Calendar var2 = this.save(var1);
      ((AbstractJpaOperations)JpaOperations.INSTANCE).flush();
      return var2;
   }

   public Object saveAndFlush(Object var1) {
      Calendar var2 = (Calendar)var1;
      return this.saveAndFlush(var2);
   }

   @Transactional
   public <S extends Calendar> List<S> saveAll(Iterable<S> var1) {
      ArrayList var4 = new ArrayList();

      for(Object var3 : var1) {
         Calendar var5 = this.save((Calendar)var3);
         var4.add(var5);
      }

      return var4;
   }

   public Iterable saveAll(Iterable var1) {
      return this.saveAll(var1);
   }

   @Transactional
   public void flush() {
      ((AbstractJpaOperations)JpaOperations.INSTANCE).flush();
   }

   public Optional<Calendar> findById(Long var1) {
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

   public Calendar getOne(Long var1) {
      JpaOperations var2 = JpaOperations.INSTANCE;
      Class var3 = this.entityClass;
      return (Calendar)RepositorySupport.getOne((AbstractJpaOperations)var2, var3, var1);
   }

   public Object getOne(Object var1) {
      Long var2 = (Long)var1;
      return this.getOne(var2);
   }

   public List<Calendar> findAll() {
      JpaOperations var1 = JpaOperations.INSTANCE;
      Class var2 = this.entityClass;
      return ((PanacheQuery)((AbstractJpaOperations)var1).findAll(var2)).list();
   }

   public Iterable findAll() {
      return this.findAll();
   }

   public List<Calendar> findAll(Sort var1) {
      io.quarkus.panache.common.Sort var4 = TypesConverter.toPanacheSort(var1);
      JpaOperations var2 = JpaOperations.INSTANCE;
      Class var3 = this.entityClass;
      return ((PanacheQuery)((AbstractJpaOperations)var2).findAll(var3, var4)).list();
   }

   public Iterable findAll(Sort var1) {
      return this.findAll(var1);
   }

   public Page<Calendar> findAll(Pageable var1) {
      Sort var2 = var1.getSort();
      io.quarkus.panache.common.Page var9 = TypesConverter.toPanachePage(var1);
      io.quarkus.panache.common.Sort var7 = TypesConverter.toPanacheSort(var2);
      PanacheQuery var8;
      if (var7 != null) {
         JpaOperations var5 = JpaOperations.INSTANCE;
         Class var6 = this.entityClass;
         var8 = (PanacheQuery)((AbstractJpaOperations)var5).findAll(var6, var7);
      } else {
         JpaOperations var3 = JpaOperations.INSTANCE;
         Class var4 = this.entityClass;
         var8 = (PanacheQuery)((AbstractJpaOperations)var3).findAll(var4);
      }

      PanacheQuery var10 = var8.page(var9);
      List var11 = var10.list();
      long var12 = var10.count();
      return (Page<Calendar>)(new PageImpl(var11, var1, var12));
   }

   public List<Calendar> findAllById(Iterable<Long> var1) {
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
         String var5 = String.format("No entity acme.Calendar with id %s exists", var4);
         throw (Throwable)(new IllegalArgumentException(var5));
      }
   }

   public void deleteById(Object var1) {
      Long var2 = (Long)var1;
      this.deleteById(var2);
   }

   @Transactional
   public void delete(Calendar var1) {
      ((AbstractJpaOperations)JpaOperations.INSTANCE).delete(var1);
   }

   public void delete(Object var1) {
      Calendar var2 = (Calendar)var1;
      this.delete(var2);
   }

   @Transactional
   public void deleteAll(Iterable<? extends Calendar> var1) {
      RepositorySupport.deleteAll((AbstractJpaOperations)JpaOperations.INSTANCE, var1);
   }

   @Transactional
   public void deleteAll() {
      JpaOperations var1 = JpaOperations.INSTANCE;
      Class var2 = this.entityClass;
      AdditionalJpaOperations.deleteAllWithCascade((AbstractJpaOperations)var1, var2);
   }

   @Transactional
   public void deleteAllInBatch() {
      JpaOperations var1 = JpaOperations.INSTANCE;
      Class var2 = this.entityClass;
      ((AbstractJpaOperations)var1).deleteAll(var2);
   }

   public void deleteInBatch(Iterable var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "deleteInBatch"));
   }

   public long count(Example var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "count"));
   }

   public List findAll(Example var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "findAll"));
   }

   public Optional findOne(Example var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "findOne"));
   }

   public boolean exists(Example var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "exists"));
   }

   public List saveAllAndFlush(Iterable var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "saveAllAndFlush"));
   }

   public List findAll(Example var1, Sort var2) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "findAll"));
   }

   public Object getReferenceById(Object var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "getReferenceById"));
   }

   public Object findBy(Example var1, Function var2) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "findBy"));
   }

   public void deleteAllById(Iterable var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "deleteAllById"));
   }

   public Page findAll(Example var1, Pageable var2) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "findAll"));
   }

   public void deleteAllByIdInBatch(Iterable var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "deleteAllByIdInBatch"));
   }

   public Iterable findAll(Example var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "findAll"));
   }

   public void deleteAllInBatch(Iterable var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "deleteAllInBatch"));
   }

   public Iterable findAll(Example var1, Sort var2) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "findAll"));
   }

   public Object getById(Object var1) {
      throw (Throwable)(new FunctionalityNotImplemented("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", "getById"));
   }
}
