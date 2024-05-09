package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.arc.ClientProxy;
import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.InjectableContext;
import io.quarkus.arc.impl.ClientProxies;
import java.util.List;
import java.util.Optional;

// $VF: synthetic class
public class AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_ClientProxy
   extends AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl
   implements ClientProxy {
   private final InjectableBean bean;
   private final InjectableContext context;

   public AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_ClientProxy(String var1) {
      ArcContainer var3 = Arc.container();
      InjectableBean var2 = var3.bean(var1);
      this.bean = var2;
      Class var4 = var2.getScope();
      Object var5 = var3.getContexts(var4).get(0);
      this.context = (InjectableContext)var5;
   }

   private AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl arc$delegate() {
      InjectableBean var1 = this.bean;
      return (AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl)ClientProxies.getApplicationScopedDelegate(this.context, var1);
   }

   public Object arc_contextualInstance() {
      return this.arc$delegate();
   }

   public InjectableBean arc_bean() {
      return this.bean;
   }

   @Override
   public List<Author> findAll() {
      return this.bean != null ? this.arc$delegate().findAll() : super.findAll();
   }

   @Override
   public <S extends Author> List<S> saveAll(Iterable<S> var1) {
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
   public boolean existsById(Object var1) {
      return this.bean != null ? this.arc$delegate().existsById(var1) : super.existsById(var1);
   }

   @Override
   public Author save(Author var1) {
      return this.bean != null ? this.arc$delegate().save(var1) : super.save(var1);
   }

   @Override
   public Iterable findAll() {
      return this.bean != null ? this.arc$delegate().findAll() : super.findAll();
   }

   @Override
   public Optional<Author> findById(Long var1) {
      return this.bean != null ? this.arc$delegate().findById(var1) : super.findById(var1);
   }

   @Override
   public List<Author> findAllById(Iterable<Long> var1) {
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
   public void deleteAll(Iterable<? extends Author> var1) {
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

   @Override
   public void delete(Author var1) {
      if (this.bean != null) {
         this.arc$delegate().delete(var1);
      } else {
         super.delete(var1);
      }
   }
}
