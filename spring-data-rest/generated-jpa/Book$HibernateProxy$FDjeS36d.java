package acme;

import java.lang.reflect.Method;
import org.hibernate.bytecode.enhance.spi.CollectionTracker;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.ManagedEntity;
import org.hibernate.engine.spi.PersistentAttributeInterceptor;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.hibernate.proxy.ProxyConfiguration;
import org.hibernate.proxy.ProxyConfiguration.Interceptor;
import org.hibernate.proxy.ProxyConfiguration.InterceptorDispatcher;

public class Book$HibernateProxy$FDjeS36d extends Book implements HibernateProxy, ProxyConfiguration {
   private Interceptor $$_hibernate_interceptor;
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$o23rrk2 = HibernateProxy.class.getMethod("getHibernateLazyInitializer");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$kvl1cd2 = Book.class.getMethod("$$_hibernate_write_id", Long.class);
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$5j4bem0 = Object.class.getMethod("equals", Object.class);
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$l9cc063 = Book.class.getMethod("getAuthor");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$7m9oaq0 = Object.class.getDeclaredMethod("clone");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$on7kt13 = Book.class.getMethod("setTitle", String.class);
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$9pqdof1 = Object.class.getMethod("hashCode");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$92kah43 = Book.class.getMethod("$$_hibernate_read_title");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$rsr7rq2 = Book.class.getMethod("$$_hibernate_read_id");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$jbj2el0 = Book.class.getMethod("$$_hibernate_write_author", Author.class);
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$4cscpe1 = Object.class.getMethod("toString");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$g2k0gh2 = Book.class.getMethod("getTitle");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$gpia792 = HibernateProxy.class.getMethod("writeReplace");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$s2c29k1 = Book.class.getMethod("$$_hibernate_read_author");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$k7hafn3 = Book.class.getMethod("getId");
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$998u3e3 = Book.class.getMethod("setAuthor", Author.class);
   // $VF: synthetic field
   private static final Method cachedValue$V7SDwGT9$ebgonk0 = Book.class.getMethod("$$_hibernate_write_title", String.class);

   public int hashCode() {
      return InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$9pqdof1, new Object[0], 0, this.$$_hibernate_interceptor);
   }

   public boolean equals(Object var1) {
      return InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$5j4bem0, new Object[]{var1}, false, this.$$_hibernate_interceptor);
   }

   protected Object clone() throws CloneNotSupportedException {
      return InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$7m9oaq0, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public String toString() {
      return (String)InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$4cscpe1, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public Long getId() {
      return (Long)InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$k7hafn3, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public String getTitle() {
      return (String)InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$g2k0gh2, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void setTitle(String var1) {
      InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$on7kt13, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public Author getAuthor() {
      return (Author)InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$l9cc063, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void setAuthor(Author var1) {
      InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$998u3e3, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public Object $$_hibernate_getEntityInstance() {
      return super.$$_hibernate_getEntityInstance();
   }

   public EntityEntry $$_hibernate_getEntityEntry() {
      return super.$$_hibernate_getEntityEntry();
   }

   public void $$_hibernate_setEntityEntry(EntityEntry var1) {
      super.$$_hibernate_setEntityEntry(var1);
   }

   public ManagedEntity $$_hibernate_getPreviousManagedEntity() {
      return super.$$_hibernate_getPreviousManagedEntity();
   }

   public void $$_hibernate_setPreviousManagedEntity(ManagedEntity var1) {
      super.$$_hibernate_setPreviousManagedEntity(var1);
   }

   public ManagedEntity $$_hibernate_getNextManagedEntity() {
      return super.$$_hibernate_getNextManagedEntity();
   }

   public void $$_hibernate_setNextManagedEntity(ManagedEntity var1) {
      super.$$_hibernate_setNextManagedEntity(var1);
   }

   public PersistentAttributeInterceptor $$_hibernate_getInterceptor() {
      return super.$$_hibernate_getInterceptor();
   }

   public void $$_hibernate_setInterceptor(PersistentAttributeInterceptor var1) {
      super.$$_hibernate_setInterceptor(var1);
   }

   public void $$_hibernate_trackChange(String var1) {
      super.$$_hibernate_trackChange(var1);
   }

   public String[] $$_hibernate_getDirtyAttributes() {
      return super.$$_hibernate_getDirtyAttributes();
   }

   public boolean $$_hibernate_hasDirtyAttributes() {
      return super.$$_hibernate_hasDirtyAttributes();
   }

   public void $$_hibernate_clearDirtyAttributes() {
      super.$$_hibernate_clearDirtyAttributes();
   }

   public void $$_hibernate_suspendDirtyTracking(boolean var1) {
      super.$$_hibernate_suspendDirtyTracking(var1);
   }

   public CollectionTracker $$_hibernate_getCollectionTracker() {
      return super.$$_hibernate_getCollectionTracker();
   }

   public Long $$_hibernate_read_id() {
      return (Long)InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$rsr7rq2, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void $$_hibernate_write_id(Long var1) {
      InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$kvl1cd2, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public String $$_hibernate_read_title() {
      return (String)InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$92kah43, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void $$_hibernate_write_title(String var1) {
      InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$ebgonk0, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public Author $$_hibernate_read_author() {
      return (Author)InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$s2c29k1, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void $$_hibernate_write_author(Author var1) {
      InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$jbj2el0, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public Object writeReplace() {
      return InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$gpia792, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public LazyInitializer getHibernateLazyInitializer() {
      return (LazyInitializer)InterceptorDispatcher.intercept(this, cachedValue$V7SDwGT9$o23rrk2, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void $$_hibernate_set_interceptor(Interceptor var1) {
      this.$$_hibernate_interceptor = var1;
   }
}
