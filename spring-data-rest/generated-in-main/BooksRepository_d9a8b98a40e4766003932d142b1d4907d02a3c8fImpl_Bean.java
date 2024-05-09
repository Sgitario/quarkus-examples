package acme;

import io.quarkus.arc.InjectableBean;
import io.quarkus.arc.InjectableInterceptor;
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
   private final Supplier interceptorProviderSupplier1;

   private BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy proxy() {
      BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy var1 = this.proxy;
      if (var1 == null) {
         var1 = new BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_ClientProxy("-Phy7Vv8mxUHXbB8sgcXpF01DnM");
         this.proxy = var1;
      }

      return var1;
   }

   public BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_Bean(Supplier var1) {
      ClassLoader var2 = Thread.currentThread().getContextClassLoader();
      this.interceptorProviderSupplier1 = var1;
      Object[] var7 = new Object[6];
      Type[] var3 = new Type[2];
      Class var4 = Class.forName("acme.Book", false, var2);
      var3[0] = var4;
      Class<Long> var5 = Long.class;
      var3[1] = var5;
      Class var6 = Class.forName("org.springframework.data.repository.CrudRepository", false, var2);
      ParameterizedTypeImpl var8 = new ParameterizedTypeImpl(var6, var3);
      var7[0] = var8;
      Class var9 = Class.forName("acme.BooksRepository", false, var2);
      var7[1] = var9;
      Type[] var10 = new Type[2];
      Class var11 = Class.forName("acme.Book", false, var2);
      var10[0] = var11;
      Class<Long> var12 = Long.class;
      var10[1] = var12;
      Class var13 = Class.forName("org.springframework.data.repository.PagingAndSortingRepository", false, var2);
      ParameterizedTypeImpl var14 = new ParameterizedTypeImpl(var13, var10);
      var7[2] = var14;
      Type[] var15 = new Type[2];
      Class var16 = Class.forName("acme.Book", false, var2);
      var15[0] = var16;
      Class<Long> var17 = Long.class;
      var15[1] = var17;
      Class var18 = Class.forName("org.springframework.data.repository.Repository", false, var2);
      ParameterizedTypeImpl var19 = new ParameterizedTypeImpl(var18, var15);
      var7[3] = var19;
      Class<Object> var20 = Object.class;
      var7[4] = var20;
      Class var21 = Class.forName("acme.BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl", false, var2);
      var7[5] = var21;
      Set var22 = Sets.of(var7);
      this.types = var22;
   }

   public String getIdentifier() {
      return "-Phy7Vv8mxUHXbB8sgcXpF01DnM";
   }

   @Override
   public Object get() {
      return this;
   }

   private BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl doCreate(CreationalContext var1) {
      Object var2 = this.interceptorProviderSupplier1.get();
      BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl var3 = new BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_Subclass(
         var1, (InjectableInterceptor)var2
      );
      ((BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl_Subclass)var3).arc$markConstructed();
      return var3;
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
               return "-Phy7Vv8mxUHXbB8sgcXpF01DnM".equals(var2);
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
      return 1617215344;
   }

   @Override
   public String toString() {
      return Beans.toString(this);
   }
}
