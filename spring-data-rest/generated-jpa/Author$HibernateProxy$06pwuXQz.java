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

public class Author$HibernateProxy$06pwuXQz extends Author implements HibernateProxy, ProxyConfiguration {
   private Interceptor $$_hibernate_interceptor;
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$o23rrk2 = HibernateProxy.class.getMethod("getHibernateLazyInitializer");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$ioepl90 = Author.class.getMethod("$$_hibernate_write_id", Long.class);
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$ng75ql2 = Author.class.getMethod("$$_hibernate_write_name", String.class);
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$b5afpi2 = Author.class.getMethod("$$_hibernate_write_dob", String.class);
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$6qr6io2 = Author.class.getMethod("$$_hibernate_read_dob");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$dgc0191 = Author.class.getMethod("getName");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$plkv4n0 = Author.class.getMethod("$$_hibernate_read_id");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$5j4bem0 = Object.class.getMethod("equals", Object.class);
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$7m9oaq0 = Object.class.getDeclaredMethod("clone");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$9pqdof1 = Object.class.getMethod("hashCode");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$4cscpe1 = Object.class.getMethod("toString");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$dqprap3 = Author.class.getMethod("setName", String.class);
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$knjtsh1 = Author.class.getMethod("$$_hibernate_read_name");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$l5o60m0 = Author.class.getMethod("setDob", String.class);
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$gpia792 = HibernateProxy.class.getMethod("writeReplace");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$i0a2pj1 = Author.class.getMethod("getId");
   // $VF: synthetic field
   private static final Method cachedValue$1vONsZGk$d8hp0g2 = Author.class.getMethod("getDob");

   public int hashCode() {
      return InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$9pqdof1, new Object[0], 0, this.$$_hibernate_interceptor);
   }

   public boolean equals(Object var1) {
      return InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$5j4bem0, new Object[]{var1}, false, this.$$_hibernate_interceptor);
   }

   protected Object clone() throws CloneNotSupportedException {
      return InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$7m9oaq0, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public String toString() {
      return (String)InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$4cscpe1, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public Long getId() {
      return (Long)InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$i0a2pj1, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public String getName() {
      return (String)InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$dgc0191, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void setName(String var1) {
      InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$dqprap3, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public String getDob() {
      return (String)InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$d8hp0g2, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void setDob(String var1) {
      InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$l5o60m0, new Object[]{var1}, null, this.$$_hibernate_interceptor);
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
      return (Long)InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$plkv4n0, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void $$_hibernate_write_id(Long var1) {
      InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$ioepl90, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public String $$_hibernate_read_name() {
      return (String)InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$knjtsh1, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void $$_hibernate_write_name(String var1) {
      InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$ng75ql2, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public String $$_hibernate_read_dob() {
      return (String)InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$6qr6io2, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void $$_hibernate_write_dob(String var1) {
      InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$b5afpi2, new Object[]{var1}, null, this.$$_hibernate_interceptor);
   }

   public Object writeReplace() {
      return InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$gpia792, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public LazyInitializer getHibernateLazyInitializer() {
      return (LazyInitializer)InterceptorDispatcher.intercept(this, cachedValue$1vONsZGk$o23rrk2, new Object[0], null, this.$$_hibernate_interceptor);
   }

   public void $$_hibernate_set_interceptor(Interceptor var1) {
      this.$$_hibernate_interceptor = var1;
   }
}
