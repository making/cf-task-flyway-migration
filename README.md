# On-off task for [Cloud Foundry V3 API](http://v3-apidocs.cloudfoundry.org/)

Run Flyway migration as a short lived task

```
cf install-plugin https://github.com/cloudfoundry/v3-cli-plugin/releases/download/0.6.5/v3-cli-plugin.osx
./mvnw clean package -DskipTests=true
jar -uvf target/flyway-migration-0.0.1-SNAPSHOT.jar Procfile 
cf v3-push flyway-migration -b java_buildpack_offline -p target/flyway-migration-0.0.1-SNAPSHOT.jar
cf create-service p-mysql 100mb demo-db
cf v3-bind-service flyway-migration demo-db 
cf v3-run-task flyway-migration migrate ".java-buildpack/open_jdk_jre/bin/java org.springframework.boot.loader.JarLauncher"
```

## Run Task

Run task 1st

``` console
$ cf v3-run-task flyway-migration migrate ".java-buildpack/open_jdk_jre/bin/java org.springframework.boot.loader.JarLauncher"
OK

Running task migrate on app flyway-migration...

Tailing logs for app flyway-migration...

2016-10-28T00:19:19.47+0900 [APP/TASK/migrate/0]OUT Creating container
2016-10-28T00:19:19.77+0900 [APP/TASK/migrate/0]OUT Successfully created container
2016-10-28T00:19:22.60+0900 [APP/TASK/migrate/0]OUT   .   ____          _            __ _ _
2016-10-28T00:19:22.60+0900 [APP/TASK/migrate/0]OUT  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
2016-10-28T00:19:22.60+0900 [APP/TASK/migrate/0]OUT ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
2016-10-28T00:19:22.60+0900 [APP/TASK/migrate/0]OUT  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
2016-10-28T00:19:22.60+0900 [APP/TASK/migrate/0]OUT   '  |____| .__|_| |_|_| |_\__, | / / / /
2016-10-28T00:19:22.60+0900 [APP/TASK/migrate/0]OUT  =========|_|==============|___/=/_/_/_/
2016-10-28T00:19:22.60+0900 [APP/TASK/migrate/0]OUT  :: Spring Boot ::        (v1.4.1.RELEASE)
2016-10-28T00:19:22.70+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:22.701  INFO 7 --- [           main] pertySourceApplicationContextInitializer : Adding 'cloud' PropertySource to ApplicationContext
2016-10-28T00:19:22.78+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:22.785  INFO 7 --- [           main] nfigurationApplicationContextInitializer : Adding cloud service auto-reconfiguration to ApplicationContext
2016-10-28T00:19:22.80+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:22.800  INFO 7 --- [           main] com.example.FlywayMigrationApplication   : Starting FlywayMigrationApplication on e3863356-acd0-4ab9-84ff-bd0f27e41846 with PID 7 (/home/vcap/app/BOOT-INF/classes started by vcap in /home/vcap/app)
2016-10-28T00:19:22.80+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:22.800  INFO 7 --- [           main] com.example.FlywayMigrationApplication   : The following profiles are active: cloud
2016-10-28T00:19:22.84+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:22.848  INFO 7 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@46fbb2c1: startup date [Thu Oct 27 15:19:22 UTC 2016]; root of context hierarchy
2016-10-28T00:19:23.44+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:23.440  INFO 7 --- [           main] urceCloudServiceBeanFactoryPostProcessor : Auto-reconfiguring beans of type javax.sql.DataSource
2016-10-28T00:19:23.45+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:23.457  INFO 7 --- [           main] o.c.r.o.s.c.s.r.PooledDataSourceCreator  : Found Tomcat high-performance connection pool on the classpath. Using it for DataSource connection pooling.
2016-10-28T00:19:23.48+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:23.488  INFO 7 --- [           main] urceCloudServiceBeanFactoryPostProcessor : Reconfigured bean dataSource into singleton service connector org.apache.tomcat.jdbc.pool.DataSource@42d3bd8b{ConnectionPool[defaultAutoCommit=null; defaultReadOnly=null; defaultTransactionIsolation=-1; defaultCatalog=null; driverClassName=com.mysql.jdbc.Driver; maxActive=4; maxIdle=100; minIdle=0; initialSize=0; maxWait=30000; testOnBorrow=true; testOnReturn=false; timeBetweenEvictionRunsMillis=5000; numTestsPerEvictionRun=0; minEvictableIdleTimeMillis=60000; testWhileIdle=false; testOnConnect=false; password=********; url=jdbc:mysql://10.0.0.67:3306/cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519?user=LB1XbYLmIqyHTl8a&password=gps2fNxEj9yQhNVD; username=null; validationQuery=/* ping */ SELECT 1; validationQueryTimeout=-1; validatorClassName=null; validationInterval=3000; accessToUnderlyingConnectionAllowed=true; removeAbandoned=false; removeAbandonedTimeout=60; logAbandoned=false; connectionProperties=null; initSQL=null; jdbcInterceptors=null; jmxEnabled=true; fairQueue=true; useEquals=true; abandonWhenPercentageFull=0; maxAge=0; useLock=false; dataSource=null; dataSourceJNDI=null; suspectTimeout=0; alternateUsernameAllowed=false; commitOnReturn=false; rollbackOnReturn=false; useDisposableConnectionFacade=true; logValidationErrors=false; propagateInterruptState=false; ignoreExceptionOnPreLoad=false; }
2016-10-28T00:19:23.78+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:23.788  INFO 7 --- [           main] o.f.core.internal.util.VersionPrinter    : Flyway 3.2.1 by Boxfuse
2016-10-28T00:19:23.79+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:23.793  WARN 7 --- [           main] o.a.tomcat.jdbc.pool.ConnectionPool      : maxIdle is larger than maxActive, setting maxIdle to: 4
2016-10-28T00:19:24.11+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:24.118  INFO 7 --- [           main] o.f.c.i.dbsupport.DbSupportFactory       : Database: jdbc:mysql://10.0.0.67:3306/cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519?user=LB1XbYLmIqyHTl8a&password=gps2fNxEj9yQhNVD (MySQL 5.5)
2016-10-28T00:19:24.15+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:24.152  INFO 7 --- [           main] o.f.core.internal.command.DbValidate     : Validated 2 migrations (execution time 00:00.015s)
2016-10-28T00:19:24.18+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:24.184  INFO 7 --- [           main] o.f.c.i.metadatatable.MetaDataTableImpl  : Creating Metadata table: `cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519`.`schema_version`
2016-10-28T00:19:24.90+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:24.908  INFO 7 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema `cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519`: << Empty Schema >>
2016-10-28T00:19:24.90+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:24.909  INFO 7 --- [           main] o.f.core.internal.command.DbMigrate      : Migrating schema `cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519` to version 1 - create-schema
2016-10-28T00:19:25.11+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:25.114  INFO 7 --- [           main] o.f.core.internal.command.DbMigrate      : Migrating schema `cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519` to version 2 - import-initial-data
2016-10-28T00:19:25.16+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:25.165  INFO 7 --- [           main] o.f.core.internal.command.DbMigrate      : Successfully applied 2 migrations to schema `cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519` (execution time 00:00.984s).
2016-10-28T00:19:25.26+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:25.259  INFO 7 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2016-10-28T00:19:25.28+0900 [APP/TASK/migrate/0]OUT {id=1, message=hello1}
2016-10-28T00:19:25.28+0900 [APP/TASK/migrate/0]OUT {id=2, message=hello2}
2016-10-28T00:19:25.28+0900 [APP/TASK/migrate/0]OUT {id=3, message=hello3}
2016-10-28T00:19:25.28+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:25.282  INFO 7 --- [           main] com.example.FlywayMigrationApplication   : Started FlywayMigrationApplication in 3.15 seconds (JVM running for 3.628)
2016-10-28T00:19:25.28+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:25.283  INFO 7 --- [       Thread-2] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@46fbb2c1: startup date [Thu Oct 27 15:19:22 UTC 2016]; root of context hierarchy
2016-10-28T00:19:25.28+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:25.284  INFO 7 --- [       Thread-2] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
2016-10-28T00:19:25.30+0900 [APP/TASK/migrate/0]OUT Exit status 0
2016-10-28T00:19:25.32+0900 [APP/TASK/migrate/0]OUT Destroying container
Task e3863356-acd0-4ab9-84ff-bd0f27e41846 successfully completed.
```

Run task 2nd

``` console
$ cf v3-run-task flyway-migration migrate ".java-buildpack/open_jdk_jre/bin/java org.springframework.boot.loader.JarLauncher"
OK

Running task migrate on app flyway-migration...

Tailing logs for app flyway-migration...

2016-10-28T00:19:42.93+0900 [APP/TASK/migrate/0]OUT Creating container
2016-10-28T00:19:43.22+0900 [APP/TASK/migrate/0]OUT Successfully created container
2016-10-28T00:19:46.04+0900 [APP/TASK/migrate/0]OUT   .   ____          _            __ _ _
2016-10-28T00:19:46.04+0900 [APP/TASK/migrate/0]OUT  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
2016-10-28T00:19:46.04+0900 [APP/TASK/migrate/0]OUT ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
2016-10-28T00:19:46.04+0900 [APP/TASK/migrate/0]OUT  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
2016-10-28T00:19:46.04+0900 [APP/TASK/migrate/0]OUT   '  |____| .__|_| |_|_| |_\__, | / / / /
2016-10-28T00:19:46.04+0900 [APP/TASK/migrate/0]OUT  =========|_|==============|___/=/_/_/_/
2016-10-28T00:19:46.04+0900 [APP/TASK/migrate/0]OUT  :: Spring Boot ::        (v1.4.1.RELEASE)
2016-10-28T00:19:46.14+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:46.143  INFO 7 --- [           main] pertySourceApplicationContextInitializer : Adding 'cloud' PropertySource to ApplicationContext
2016-10-28T00:19:46.25+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:46.250  INFO 7 --- [           main] nfigurationApplicationContextInitializer : Adding cloud service auto-reconfiguration to ApplicationContext
2016-10-28T00:19:46.26+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:46.264  INFO 7 --- [           main] com.example.FlywayMigrationApplication   : Starting FlywayMigrationApplication on f4272997-5951-4de0-a473-c8275108ca8d with PID 7 (/home/vcap/app/BOOT-INF/classes started by vcap in /home/vcap/app)
2016-10-28T00:19:46.26+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:46.264  INFO 7 --- [           main] com.example.FlywayMigrationApplication   : The following profiles are active: cloud
2016-10-28T00:19:46.31+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:46.312  INFO 7 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@46fbb2c1: startup date [Thu Oct 27 15:19:46 UTC 2016]; root of context hierarchy
2016-10-28T00:19:46.91+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:46.918  INFO 7 --- [           main] urceCloudServiceBeanFactoryPostProcessor : Auto-reconfiguring beans of type javax.sql.DataSource
2016-10-28T00:19:46.93+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:46.935  INFO 7 --- [           main] o.c.r.o.s.c.s.r.PooledDataSourceCreator  : Found Tomcat high-performance connection pool on the classpath. Using it for DataSource connection pooling.
2016-10-28T00:19:46.95+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:46.959  INFO 7 --- [           main] urceCloudServiceBeanFactoryPostProcessor : Reconfigured bean dataSource into singleton service connector org.apache.tomcat.jdbc.pool.DataSource@42d3bd8b{ConnectionPool[defaultAutoCommit=null; defaultReadOnly=null; defaultTransactionIsolation=-1; defaultCatalog=null; driverClassName=com.mysql.jdbc.Driver; maxActive=4; maxIdle=100; minIdle=0; initialSize=0; maxWait=30000; testOnBorrow=true; testOnReturn=false; timeBetweenEvictionRunsMillis=5000; numTestsPerEvictionRun=0; minEvictableIdleTimeMillis=60000; testWhileIdle=false; testOnConnect=false; password=********; url=jdbc:mysql://10.0.0.67:3306/cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519?user=LB1XbYLmIqyHTl8a&password=gps2fNxEj9yQhNVD; username=null; validationQuery=/* ping */ SELECT 1; validationQueryTimeout=-1; validatorClassName=null; validationInterval=3000; accessToUnderlyingConnectionAllowed=true; removeAbandoned=false; removeAbandonedTimeout=60; logAbandoned=false; connectionProperties=null; initSQL=null; jdbcInterceptors=null; jmxEnabled=true; fairQueue=true; useEquals=true; abandonWhenPercentageFull=0; maxAge=0; useLock=false; dataSource=null; dataSourceJNDI=null; suspectTimeout=0; alternateUsernameAllowed=false; commitOnReturn=false; rollbackOnReturn=false; useDisposableConnectionFacade=true; logValidationErrors=false; propagateInterruptState=false; ignoreExceptionOnPreLoad=false; }
2016-10-28T00:19:47.28+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.288  INFO 7 --- [           main] o.f.core.internal.util.VersionPrinter    : Flyway 3.2.1 by Boxfuse
2016-10-28T00:19:47.29+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.294  WARN 7 --- [           main] o.a.tomcat.jdbc.pool.ConnectionPool      : maxIdle is larger than maxActive, setting maxIdle to: 4
2016-10-28T00:19:47.62+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.628  INFO 7 --- [           main] o.f.c.i.dbsupport.DbSupportFactory       : Database: jdbc:mysql://10.0.0.67:3306/cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519?user=LB1XbYLmIqyHTl8a&password=gps2fNxEj9yQhNVD (MySQL 5.5)
2016-10-28T00:19:47.67+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.675  INFO 7 --- [           main] o.f.core.internal.command.DbValidate     : Validated 2 migrations (execution time 00:00.026s)
2016-10-28T00:19:47.72+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.727  INFO 7 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema `cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519`: 2
2016-10-28T00:19:47.72+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.729  INFO 7 --- [           main] o.f.core.internal.command.DbMigrate      : Schema `cf_0c96b5f1_14e7_49ce_9bf9_0e74bb192519` is up to date. No migration necessary.
2016-10-28T00:19:47.80+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.801  INFO 7 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2016-10-28T00:19:47.82+0900 [APP/TASK/migrate/0]OUT {id=1, message=hello1}
2016-10-28T00:19:47.82+0900 [APP/TASK/migrate/0]OUT {id=2, message=hello2}
2016-10-28T00:19:47.82+0900 [APP/TASK/migrate/0]OUT {id=3, message=hello3}
2016-10-28T00:19:47.82+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.827  INFO 7 --- [           main] com.example.FlywayMigrationApplication   : Started FlywayMigrationApplication in 2.273 seconds (JVM running for 2.724)
2016-10-28T00:19:47.82+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.828  INFO 7 --- [       Thread-2] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@46fbb2c1: startup date [Thu Oct 27 15:19:46 UTC 2016]; root of context hierarchy
2016-10-28T00:19:47.83+0900 [APP/TASK/migrate/0]OUT 2016-10-27 15:19:47.832  INFO 7 --- [       Thread-2] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
2016-10-28T00:19:47.85+0900 [APP/TASK/migrate/0]OUT Exit status 0
2016-10-28T00:19:47.88+0900 [APP/TASK/migrate/0]OUT Destroying container
Task f4272997-5951-4de0-a473-c8275108ca8d successfully completed.
```

## Task results

``` console
$ cf v3-tasks flyway-migration
Listing tasks for app flyway-migration...
id   state       start time             name      command   
0    SUCCEEDED   Oct 27, 15:19:19 UTC   migrate   [PRIVATE DATA HIDDEN IN LISTS]   
0    SUCCEEDED   Oct 27, 15:19:42 UTC   migrate   [PRIVATE DATA HIDDEN IN LISTS] 
```


## Delete Task


``` console
$ cf curl /v3/service_bindings
{
   "pagination": {
      "total_results": 1,
      "total_pages": 1,
      "first": {
         "href": "/v3/service_bindings?page=1&per_page=50"
      },
      "last": {
         "href": "/v3/service_bindings?page=1&per_page=50"
      },
      "next": null,
      "previous": null
   },
   "resources": [
      {
         "guid": "62223a7b-fe80-4e77-9184-72f3ff15a4c9",
         "type": "app",
         "data": {
            "credentials": {
               "redacted_message": "[PRIVATE DATA HIDDEN IN LISTS]"
            },
            "syslog_drain_url": null,
            "volume_mounts": []
         },
         "created_at": "2016-10-27T15:18:21Z",
         "updated_at": null,
         "links": {
            "self": {
               "href": "/v3/service_bindings/62223a7b-fe80-4e77-9184-72f3ff15a4c9"
            },
            "service_instance": {
               "href": "/v2/service_instances/0c96b5f1-14e7-49ce-9bf9-0e74bb192519"
            },
            "app": {
               "href": "/v3/apps/cf33e3e8-4d58-479c-bc45-2549b973f015"
            }
         }
      }
   ]
}
$ cf curl -X DELETE /v3/service_bindings/62223a7b-fe80-4e77-9184-72f3ff15a4c9
$ cf v3-delete flyway-migration
Deleting app flyway-migration...
OK
```