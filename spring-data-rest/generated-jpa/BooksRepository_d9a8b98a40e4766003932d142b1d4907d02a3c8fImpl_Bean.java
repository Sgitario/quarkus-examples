package acme;

import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.impl.Beans;
import io.quarkus.arc.impl.ParameterizedTypeImpl;
import io.quarkus.arc.impl.Sets;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.CreationException;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.function.Supplier;

// $VF: synthetic class
public class BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_Bean implements InjectableBean, Supplier {
   private final Set types;
   private volatile BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy proxy;

   private BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy proxy() {
      BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy var1 = this.proxy;
      if (var1 == null) {
         var1 = new BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy("8Fm6Z9l2xDB-_G2ergx1dLmaVjc");
         this.proxy = var1;
      }

      return var1;
   }

   public BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_Bean() {
      ClassLoader var1 = Thread.currentThread().getContextClassLoader();
      Object[] var2 = new Object[5];
      Class var3 = Class.forName("acme.BooksRepository", false, var1);
      var2[0] = var3;
      Type[] var4 = new Type[2];
      Class var5 = Class.forName("acme.Book", false, var1);
      var4[0] = var5;
      Class<Long> var6 = Long.class;
      var4[1] = var6;
      Class var7 = Class.forName("org.springframework.data.repository.PagingAndSortingRepository", false, var1);
      ParameterizedTypeImpl var8 = new ParameterizedTypeImpl(var7, var4);
      var2[1] = var8;
      Type[] var9 = new Type[2];
      Class var10 = Class.forName("acme.Book", false, var1);
      var9[0] = var10;
      Class<Long> var11 = Long.class;
      var9[1] = var11;
      Class var12 = Class.forName("org.springframework.data.repository.Repository", false, var1);
      ParameterizedTypeImpl var13 = new ParameterizedTypeImpl(var12, var9);
      var2[2] = var13;
      Class<Object> var14 = Object.class;
      var2[3] = var14;
      Class var15 = Class.forName("acme.BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl", false, var1);
      var2[4] = var15;
      Set var16 = Sets.of(var2);
      this.types = var16;
   }

   public String getIdentifier() {
      return "8Fm6Z9l2xDB-_G2ergx1dLmaVjc";
   }

   @Override
   public Object get() {
      return this;
   }

   private BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl doCreate(CreationalContext var1) {
      return new BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl();
   }

   public BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl create(CreationalContext var1) {
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

   public BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl get(CreationalContext var1) {
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
      return BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl.class;
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
               return "8Fm6Z9l2xDB-_G2ergx1dLmaVjc".equals(var2);
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
      return -344995945;
   }

   @Override
   public String toString() {
      return Beans.toString(this);
   }
}
