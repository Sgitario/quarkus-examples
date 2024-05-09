package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.arc.ClientProxy;
import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.InjectableContext;
import io.quarkus.arc.impl.ClientProxies;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

// $VF: synthetic class
public class CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_ClientProxy
   extends CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl
   implements ClientProxy {
   private final InjectableBean bean;
   private final InjectableContext context;

   public CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_ClientProxy(String var1) {
      ArcContainer var3 = Arc.container();
      InjectableBean var2 = var3.bean(var1);
      this.bean = var2;
      Class var4 = var2.getScope();
      Object var5 = var3.getContexts(var4).get(0);
      this.context = (InjectableContext)var5;
   }

   private CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl arc$delegate() {
      InjectableBean var1 = this.bean;
      return (CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl)ClientProxies.getApplicationScopedDelegate(this.context, var1);
   }

   public Object arc_contextualInstance() {
      return this.arc$delegate();
   }

   public InjectableBean arc_bean() {
      return this.bean;
   }

   @Override
   public long count() {
      return this.bean != null ? this.arc$delegate().count() : super.count();
   }

   @Override
   public boolean existsById(Long var1) {
      return this.bean != null ? this.arc$delegate().existsById(var1) : super.existsById(var1);
   }

   @Override
   public String toString() {
      return this.bean != null ? this.arc$delegate().toString() : super.toString();
   }

   @Override
   public Object getById(Object var1) {
      return this.bean != null ? this.arc$delegate().getById(var1) : super.getById(var1);
   }

   @Override
   public void deleteAllById(Iterable var1) {
      if (this.bean != null) {
         this.arc$delegate().deleteAllById(var1);
      } else {
         super.deleteAllById(var1);
      }
   }

   @Override
   public Object save(Object var1) {
      return this.bean != null ? this.arc$delegate().save(var1) : super.save(var1);
   }

   @Override
   public void delete(Calendar var1) {
      if (this.bean != null) {
         this.arc$delegate().delete(var1);
      } else {
         super.delete(var1);
      }
   }

   @Override
   public Iterable findAllById(Iterable var1) {
      return this.bean != null ? this.arc$delegate().findAllById(var1) : super.findAllById(var1);
   }

   @Override
   public List findAll(Example var1) {
      return this.bean != null ? this.arc$delegate().findAll(var1) : super.findAll(var1);
   }

   @Override
   public void deleteInBatch(Iterable var1) {
      if (this.bean != null) {
         this.arc$delegate().deleteInBatch(var1);
      } else {
         super.deleteInBatch(var1);
      }
   }

   @Override
   public boolean existsById(Object var1) {
      return this.bean != null ? this.arc$delegate().existsById(var1) : super.existsById(var1);
   }

   @Override
   public void deleteAllByIdInBatch(Iterable var1) {
      if (this.bean != null) {
         this.arc$delegate().deleteAllByIdInBatch(var1);
      } else {
         super.deleteAllByIdInBatch(var1);
      }
   }

   @Override
   public Iterable findAll(Sort var1) {
      return this.bean != null ? this.arc$delegate().findAll(var1) : super.findAll(var1);
   }

   @Override
   public Optional findOne(Example var1) {
      return this.bean != null ? this.arc$delegate().findOne(var1) : super.findOne(var1);
   }

   @Override
   public Calendar saveAndFlush(Calendar var1) {
      return this.bean != null ? this.arc$delegate().saveAndFlush(var1) : super.saveAndFlush(var1);
   }

   @Override
   public Calendar getOne(Long var1) {
      return this.bean != null ? this.arc$delegate().getOne(var1) : super.getOne(var1);
   }

   @Override
   public void deleteAll(Iterable<? extends Calendar> var1) {
      if (this.bean != null) {
         this.arc$delegate().deleteAll(var1);
      } else {
         super.deleteAll(var1);
      }
   }

   @Override
   public Iterable findAll(Example var1, Sort var2) {
      return this.bean != null ? this.arc$delegate().findAll(var1, var2) : super.findAll(var1, var2);
   }

   @Override
   public List findAll(Example var1, Sort var2) {
      return this.bean != null ? this.arc$delegate().findAll(var1, var2) : super.findAll(var1, var2);
   }

   @Override
   public Iterable findAll(Example var1) {
      return this.bean != null ? this.arc$delegate().findAll(var1) : super.findAll(var1);
   }

   @Override
   public void deleteAllInBatch() {
      if (this.bean != null) {
         this.arc$delegate().deleteAllInBatch();
      } else {
         super.deleteAllInBatch();
      }
   }

   @Override
   public Iterable saveAll(Iterable var1) {
      return this.bean != null ? this.arc$delegate().saveAll(var1) : super.saveAll(var1);
   }

   @Override
   public List<Calendar> findAll() {
      return this.bean != null ? this.arc$delegate().findAll() : super.findAll();
   }

   @Override
   public <S extends Calendar> List<S> saveAll(Iterable<S> var1) {
      return this.bean != null ? this.arc$delegate().saveAll(var1) : super.saveAll(var1);
   }

   @Override
   public Calendar save(Calendar var1) {
      return this.bean != null ? this.arc$delegate().save(var1) : super.save(var1);
   }

   @Override
   public Object getReferenceById(Object var1) {
      return this.bean != null ? this.arc$delegate().getReferenceById(var1) : super.getReferenceById(var1);
   }

   @Override
   public void deleteAll() {
      if (this.bean != null) {
         this.arc$delegate().deleteAll();
      } else {
         super.deleteAll();
      }
   }

   @Override
   public List saveAllAndFlush(Iterable var1) {
      return this.bean != null ? this.arc$delegate().saveAllAndFlush(var1) : super.saveAllAndFlush(var1);
   }

   @Override
   public List<Calendar> findAll(Sort var1) {
      return this.bean != null ? this.arc$delegate().findAll(var1) : super.findAll(var1);
   }

   @Override
   public Object getOne(Object var1) {
      return this.bean != null ? this.arc$delegate().getOne(var1) : super.getOne(var1);
   }

   @Override
   public Iterable findAll() {
      return this.bean != null ? this.arc$delegate().findAll() : super.findAll();
   }

   @Override
   public Page<Calendar> findAll(Pageable var1) {
      return this.bean != null ? this.arc$delegate().findAll(var1) : super.findAll(var1);
   }

   @Override
   public Optional<Calendar> findById(Long var1) {
      return this.bean != null ? this.arc$delegate().findById(var1) : super.findById(var1);
   }

   @Override
   public Object findBy(Example var1, Function var2) {
      return this.bean != null ? this.arc$delegate().findBy(var1, var2) : super.findBy(var1, var2);
   }

   @Override
   public void flush() {
      if (this.bean != null) {
         this.arc$delegate().flush();
      } else {
         super.flush();
      }
   }

   @Override
   public List<Calendar> findAllById(Iterable<Long> var1) {
      return this.bean != null ? this.arc$delegate().findAllById(var1) : super.findAllById(var1);
   }

   @Override
   public Page findAll(Example var1, Pageable var2) {
      return this.bean != null ? this.arc$delegate().findAll(var1, var2) : super.findAll(var1, var2);
   }

   @Override
   public void delete(Object var1) {
      if (this.bean != null) {
         this.arc$delegate().delete(var1);
      } else {
         super.delete(var1);
      }
   }

   @Override
   public Object saveAndFlush(Object var1) {
      return this.bean != null ? this.arc$delegate().saveAndFlush(var1) : super.saveAndFlush(var1);
   }

   @Override
   public Optional findById(Object var1) {
      return this.bean != null ? this.arc$delegate().findById(var1) : super.findById(var1);
   }

   @Override
   public boolean exists(Example var1) {
      return this.bean != null ? this.arc$delegate().exists(var1) : super.exists(var1);
   }

   @Override
   public void deleteById(Long var1) {
      if (this.bean != null) {
         this.arc$delegate().deleteById(var1);
      } else {
         super.deleteById(var1);
      }
   }

   @Override
   public void deleteAllInBatch(Iterable var1) {
      if (this.bean != null) {
         this.arc$delegate().deleteAllInBatch(var1);
      } else {
         super.deleteAllInBatch(var1);
      }
   }

   @Override
   public long count(Example var1) {
      return this.bean != null ? this.arc$delegate().count(var1) : super.count(var1);
   }

   @Override
   public void deleteById(Object var1) {
      if (this.bean != null) {
         this.arc$delegate().deleteById(var1);
      } else {
         super.deleteById(var1);
      }
   }
}
