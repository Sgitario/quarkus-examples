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
public class AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_Bean implements InjectableBean, Supplier {
   private final Set types;
   private volatile AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_ClientProxy proxy;
   private final Supplier interceptorProviderSupplier1;

   private AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_ClientProxy proxy() {
      AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_ClientProxy var1 = this.proxy;
      if (var1 == null) {
         var1 = new AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_ClientProxy("z7MVQxIdl2GHdmPH66zuHTkThgk");
         this.proxy = var1;
      }

      return var1;
   }

   public AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_Bean(Supplier var1) {
      ClassLoader var2 = Thread.currentThread().getContextClassLoader();
      this.interceptorProviderSupplier1 = var1;
      Object[] var3 = new Object[5];
      Class var4 = Class.forName("acme.AuthorsRepository", false, var2);
      var3[0] = var4;
      Type[] var5 = new Type[2];
      Class var6 = Class.forName("acme.Author", false, var2);
      var5[0] = var6;
      Class<Long> var7 = Long.class;
      var5[1] = var7;
      Class var8 = Class.forName("org.springframework.data.repository.CrudRepository", false, var2);
      ParameterizedTypeImpl var9 = new ParameterizedTypeImpl(var8, var5);
      var3[1] = var9;
      Class var10 = Class.forName("acme.AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl", false, var2);
      var3[2] = var10;
      Type[] var11 = new Type[2];
      Class var12 = Class.forName("acme.Author", false, var2);
      var11[0] = var12;
      Class<Long> var13 = Long.class;
      var11[1] = var13;
      Class var14 = Class.forName("org.springframework.data.repository.Repository", false, var2);
      ParameterizedTypeImpl var15 = new ParameterizedTypeImpl(var14, var11);
      var3[3] = var15;
      Class<Object> var16 = Object.class;
      var3[4] = var16;
      Set var17 = Sets.of(var3);
      this.types = var17;
   }

   public String getIdentifier() {
      return "z7MVQxIdl2GHdmPH66zuHTkThgk";
   }

   @Override
   public Object get() {
      return this;
   }

   private AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl doCreate(CreationalContext var1) {
      Object var2 = this.interceptorProviderSupplier1.get();
      AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl var3 = new AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_Subclass(
         var1, (InjectableInterceptor)var2
      );
      ((AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl_Subclass)var3).arc$markConstructed();
      return var3;
   }

   public AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl create(CreationalContext var1) {
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

   public AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl get(CreationalContext var1) {
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
      return AuthorsRepository_e12acf7985d291f8b895b3918294612f06ce6513Impl.class;
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
               return "z7MVQxIdl2GHdmPH66zuHTkThgk".equals(var2);
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
      return 898320876;
   }

   @Override
   public String toString() {
      return Beans.toString(this);
   }
}
