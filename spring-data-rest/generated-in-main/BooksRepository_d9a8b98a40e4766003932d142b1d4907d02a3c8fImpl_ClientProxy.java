package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.arc.ClientProxy;
import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.InjectableContext;
import io.quarkus.arc.impl.ClientProxies;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

// $VF: synthetic class
public class BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy
   extends BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl
   implements ClientProxy {
   private final InjectableBean bean;
   private final InjectableContext context;

   public BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy(String var1) {
      ArcContainer var3 = Arc.container();
      InjectableBean var2 = var3.bean(var1);
      this.bean = var2;
      Class var4 = var2.getScope();
      Object var5 = var3.getContexts(var4).get(0);
      this.context = (InjectableContext)var5;
   }

   private BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl arc$delegate() {
      InjectableBean var1 = this.bean;
      return (BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl)ClientProxies.getApplicationScopedDelegate(this.context, var1);
   }

   public Object arc_contextualInstance() {
      return this.arc$delegate();
   }

   public InjectableBean arc_bean() {
      return this.bean;
   }

   @Override
   public List<Book> findAll() {
      return this.bean != null ? this.arc$delegate().findAll() : super.findAll();
   }

   @Override
   public <S extends Book> List<S> saveAll(Iterable<S> var1) {
      return this.bean != null ? this.arc$delegate().saveAll(var1) : super.saveAll(var1);
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
   public Object save(Object var1) {
      return this.bean != null ? this.arc$delegate().save(var1) : super.save(var1);
   }

   @Override
   public Iterable findAllById(Iterable var1) {
      return this.bean != null ? this.arc$delegate().findAllById(var1) : super.findAllById(var1);
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
   public List<Book> findAll(Sort var1) {
      return this.bean != null ? this.arc$delegate().findAll(var1) : super.findAll(var1);
   }

   @Override
   public boolean existsById(Object var1) {
      return this.bean != null ? this.arc$delegate().existsById(var1) : super.existsById(var1);
   }

   @Override
   public void delete(Book var1) {
      if (this.bean != null) {
         this.arc$delegate().delete(var1);
      } else {
         super.delete(var1);
      }
   }

   @Override
   public Iterable findAll() {
      return this.bean != null ? this.arc$delegate().findAll() : super.findAll();
   }

   @Override
   public Iterable findAll(Sort var1) {
      return this.bean != null ? this.arc$delegate().findAll(var1) : super.findAll(var1);
   }

   @Override
   public Page<Book> findAll(Pageable var1) {
      return this.bean != null ? this.arc$delegate().findAll(var1) : super.findAll(var1);
   }

   @Override
   public Book save(Book var1) {
      return this.bean != null ? this.arc$delegate().save(var1) : super.save(var1);
   }

   @Override
   public Optional<Book> findById(Long var1) {
      return this.bean != null ? this.arc$delegate().findById(var1) : super.findById(var1);
   }

   @Override
   public List<Book> findAllById(Iterable<Long> var1) {
      return this.bean != null ? this.arc$delegate().findAllById(var1) : super.findAllById(var1);
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
   public void deleteAll(Iterable<? extends Book> var1) {
      if (this.bean != null) {
         this.arc$delegate().deleteAll(var1);
      } else {
         super.deleteAll(var1);
      }
   }

   @Override
   public Optional findById(Object var1) {
      return this.bean != null ? this.arc$delegate().findById(var1) : super.findById(var1);
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
   public Iterable saveAll(Iterable var1) {
      return this.bean != null ? this.arc$delegate().saveAll(var1) : super.saveAll(var1);
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
