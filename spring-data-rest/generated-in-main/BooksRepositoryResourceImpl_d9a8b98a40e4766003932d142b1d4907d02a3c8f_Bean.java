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
public class BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f_Bean implements InjectableBean, Supplier {
   private final Set types;
   private volatile BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f_ClientProxy proxy;

   private BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f_ClientProxy proxy() {
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f_ClientProxy var1 = this.proxy;
      if (var1 == null) {
         var1 = new BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f_ClientProxy("L_MgH40u0LDgb9Kpp9hm09VT5c4");
         this.proxy = var1;
      }

      return var1;
   }

   public BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f_Bean() {
      ClassLoader var1 = Thread.currentThread().getContextClassLoader();
      Object[] var2 = new Object[3];
      Class var3 = Class.forName("io.quarkus.rest.data.panache.RestDataResource", false, var1);
      var2[0] = var3;
      Class var4 = Class.forName("acme.BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f", false, var1);
      var2[1] = var4;
      Class<Object> var5 = Object.class;
      var2[2] = var5;
      Set var6 = Sets.of(var2);
      this.types = var6;
   }

   public String getIdentifier() {
      return "L_MgH40u0LDgb9Kpp9hm09VT5c4";
   }

   @Override
   public Object get() {
      return this;
   }

   private BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f doCreate(CreationalContext var1) {
      return new BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f();
   }

   public BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f create(CreationalContext var1) {
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

   public BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f get(CreationalContext var1) {
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
      return BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f.class;
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
               return "L_MgH40u0LDgb9Kpp9hm09VT5c4".equals(var2);
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
      return -1634412808;
   }

   @Override
   public String toString() {
      return Beans.toString(this);
   }
}
