package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.InjectableReferenceProvider;
import io.quarkus.arc.impl.Beans;
import io.quarkus.arc.impl.CreationalContextImpl;
import io.quarkus.arc.impl.Sets;
import jakarta.enterprise.context.spi.Context;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.CreationException;
import jakarta.inject.Singleton;
import java.util.Set;
import java.util.function.Supplier;

// $VF: synthetic class
public class AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513_Bean implements InjectableBean, Supplier {
   private final Set types;
   private final Supplier injectProviderSupplier1;

   public AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513_Bean(Supplier var1) {
      ClassLoader var2 = Thread.currentThread().getContextClassLoader();
      this.injectProviderSupplier1 = var1;
      Object[] var3 = new Object[2];
      Class var4 = Class.forName("acme.AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513", false, var2);
      var3[0] = var4;
      Class<Object> var5 = Object.class;
      var3[1] = var5;
      Set var6 = Sets.of(var3);
      this.types = var6;
   }

   public String getIdentifier() {
      return "LHOMkY2NAJxyjWahBg5EXXeuBbk";
   }

   @Override
   public Object get() {
      return this;
   }

   private AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513 doCreate(CreationalContext var1) {
      AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513 var4 = new AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513();

      try {
         Object var2 = this.injectProviderSupplier1.get();
         CreationalContextImpl var3 = CreationalContextImpl.child((InjectableReferenceProvider)var2, var1);
         Object var5 = ((InjectableReferenceProvider)var2).get((CreationalContext)var3);
         var4.resource = (AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513)var5;
         return var4;
      } catch (RuntimeException var7) {
         throw (Throwable)(
            new RuntimeException(
               "Error injecting acme.AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 acme.AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513.resource",
               var7
            )
         );
      }
   }

   public AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513 create(CreationalContext var1) {
      try {
         return this.doCreate(var1);
      } catch (Exception var3) {
         if (var3 instanceof RuntimeException) {
            throw (Throwable)var3;
         } else {
            throw (Throwable)(new CreationException(var3));
         }
      }
   }

   // $VF: bridge method
   public Object create(CreationalContext var1) {
      return this.create(var1);
   }

   public AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513 get(CreationalContext var1) {
      ArcContainer var2 = Arc.container();
      CreationalContextImpl var3 = new CreationalContextImpl((Contextual)this);
      return (AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513)((Context)var2.getActiveContext(Singleton.class))
         .get((Contextual)this, (CreationalContext)var3);
   }

   // $VF: bridge method
   public Object get(CreationalContext var1) {
      return this.get(var1);
   }

   public Set getTypes() {
      return this.types;
   }

   public Class getScope() {
      return Singleton.class;
   }

   public Class getBeanClass() {
      return AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513.class;
   }

   public boolean isSuppressed() {
      return false;
   }

   @Override
   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 != null) {
            if (var1 instanceof InjectableBean) {
               String var2 = ((InjectableBean)var1).getIdentifier();
               return "LHOMkY2NAJxyjWahBg5EXXeuBbk".equals(var2);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   @Override
   public int hashCode() {
      return 158698532;
   }

   @Override
   public String toString() {
      return Beans.toString(this);
   }
}
