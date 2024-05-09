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
public class CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Bean implements InjectableBean, Supplier {
   private final Set types;
   private volatile CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_ClientProxy proxy;
   private final Supplier interceptorProviderSupplier1;

   private CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_ClientProxy proxy() {
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_ClientProxy var1 = this.proxy;
      if (var1 == null) {
         var1 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_ClientProxy("uiW34_Trlzny3yV5oAEn2MNB5vc");
         this.proxy = var1;
      }

      return var1;
   }

   public CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Bean(Supplier var1) {
      ClassLoader var2 = Thread.currentThread().getContextClassLoader();
      this.interceptorProviderSupplier1 = var1;
      Object[] var3 = new Object[10];
      Class var4 = Class.forName("acme.CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl", false, var2);
      var3[0] = var4;
      Type[] var5 = new Type[2];
      Class var6 = Class.forName("acme.Calendar", false, var2);
      var5[0] = var6;
      Class<Long> var7 = Long.class;
      var5[1] = var7;
      Class var8 = Class.forName("org.springframework.data.repository.ListCrudRepository", false, var2);
      ParameterizedTypeImpl var9 = new ParameterizedTypeImpl(var8, var5);
      var3[1] = var9;
      Class var10 = Class.forName("acme.CalendarRepository", false, var2);
      var3[2] = var10;
      Type[] var11 = new Type[2];
      Class var12 = Class.forName("acme.Calendar", false, var2);
      var11[0] = var12;
      Class<Long> var13 = Long.class;
      var11[1] = var13;
      Class var14 = Class.forName("org.springframework.data.repository.ListPagingAndSortingRepository", false, var2);
      ParameterizedTypeImpl var15 = new ParameterizedTypeImpl(var14, var11);
      var3[3] = var15;
      Type[] var16 = new Type[2];
      Class var17 = Class.forName("acme.Calendar", false, var2);
      var16[0] = var17;
      Class<Long> var18 = Long.class;
      var16[1] = var18;
      Class var19 = Class.forName("org.springframework.data.jpa.repository.JpaRepository", false, var2);
      ParameterizedTypeImpl var20 = new ParameterizedTypeImpl(var19, var16);
      var3[4] = var20;
      Type[] var21 = new Type[2];
      Class var22 = Class.forName("acme.Calendar", false, var2);
      var21[0] = var22;
      Class<Long> var23 = Long.class;
      var21[1] = var23;
      Class var24 = Class.forName("org.springframework.data.repository.Repository", false, var2);
      ParameterizedTypeImpl var25 = new ParameterizedTypeImpl(var24, var21);
      var3[5] = var25;
      Class<Object> var26 = Object.class;
      var3[6] = var26;
      Type[] var27 = new Type[2];
      Class var28 = Class.forName("acme.Calendar", false, var2);
      var27[0] = var28;
      Class<Long> var29 = Long.class;
      var27[1] = var29;
      Class var30 = Class.forName("org.springframework.data.repository.CrudRepository", false, var2);
      ParameterizedTypeImpl var31 = new ParameterizedTypeImpl(var30, var27);
      var3[7] = var31;
      Type[] var32 = new Type[2];
      Class var33 = Class.forName("acme.Calendar", false, var2);
      var32[0] = var33;
      Class<Long> var34 = Long.class;
      var32[1] = var34;
      Class var35 = Class.forName("org.springframework.data.repository.PagingAndSortingRepository", false, var2);
      ParameterizedTypeImpl var36 = new ParameterizedTypeImpl(var35, var32);
      var3[8] = var36;
      Type[] var37 = new Type[1];
      Class var38 = Class.forName("acme.Calendar", false, var2);
      var37[0] = var38;
      Class var39 = Class.forName("org.springframework.data.repository.query.QueryByExampleExecutor", false, var2);
      ParameterizedTypeImpl var40 = new ParameterizedTypeImpl(var39, var37);
      var3[9] = var40;
      Set var41 = Sets.of(var3);
      this.types = var41;
   }

   public String getIdentifier() {
      return "uiW34_Trlzny3yV5oAEn2MNB5vc";
   }

   @Override
   public Object get() {
      return this;
   }

   private CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl doCreate(CreationalContext var1) {
      Object var2 = this.interceptorProviderSupplier1.get();
      CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl var3 = new CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass(
         var1, (InjectableInterceptor)var2
      );
      ((CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl_Subclass)var3).arc$markConstructed();
      return var3;
   }

   public CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl create(CreationalContext var1) {
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

   public CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl get(CreationalContext var1) {
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
      return CalendarRepository_253b5300496aea63c836aa077421802281ec4c5bImpl.class;
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
               return "uiW34_Trlzny3yV5oAEn2MNB5vc".equals(var2);
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
      return 2136217153;
   }

   @Override
   public String toString() {
      return Beans.toString(this);
   }
}
