package acme;

import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.impl.Beans;
import io.quarkus.arc.impl.Sets;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.CreationException;
import java.util.Set;
import java.util.function.Supplier;

// $VF: synthetic class
public class AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513_Bean implements InjectableBean, Supplier {
   private final Set types;
   private volatile AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513_ClientProxy proxy;

   private AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513_ClientProxy proxy() {
      AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513_ClientProxy var1 = this.proxy;
      if (var1 == null) {
         var1 = new AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513_ClientProxy("fYPbobO9vIxTKNL30nCcWRKghb0");
         this.proxy = var1;
      }

      return var1;
   }

   public AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513_Bean() {
      ClassLoader var1 = Thread.currentThread().getContextClassLoader();
      Object[] var2 = new Object[3];
      Class var3 = Class.forName("io.quarkus.rest.data.panache.RestDataResource", false, var1);
      var2[0] = var3;
      Class<Object> var4 = Object.class;
      var2[1] = var4;
      Class var5 = Class.forName("acme.AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513", false, var1);
      var2[2] = var5;
      Set var6 = Sets.of(var2);
      this.types = var6;
   }

   public String getIdentifier() {
      return "fYPbobO9vIxTKNL30nCcWRKghb0";
   }

   @Override
   public Object get() {
      return this;
   }

   private AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 doCreate(CreationalContext var1) {
      return new AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513();
   }

   public AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 create(CreationalContext var1) {
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

   public AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 get(CreationalContext var1) {
      return this.proxy();
   }

   // $VF: bridge method
   public Object get(CreationalContext var1) {
      return this.get(var1);
   }

   public Set getTypes() {
      return this.types;
   }

   public Class getScope() {
      return ApplicationScoped.class;
   }

   public Class getBeanClass() {
      return AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513.class;
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
               return "fYPbobO9vIxTKNL30nCcWRKghb0".equals(var2);
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
      return -198581754;
   }

   @Override
   public String toString() {
      return Beans.toString(this);
   }
}
