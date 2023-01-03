dataSource {
	pooled = true
    properties {
        testOnBorrow = true
        testWhileIdle = true
        testOnReturn = true
        validationQuery = "SELECT 1"
    }
	driverClassName = "org.postgresql.Driver"
	username = "postgres"
	password = "postgres"
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
//   cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
	cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
	singleSession = true // configure OSIV singleSession mode
	flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// phase2 for test server
// nba for development

environments {
	development {
		dataSource {
			dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
			//url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			//url = "jdbc:postgresql://10.23.249.53:5432/MOES_PMS" //For Moes linux server
//			  url = "jdbc:postgresql://10.247.55.40:5432/nba"

	        url = "jdbc:postgresql://localhost:5432/nba"
//			url = "jdbc:postgresql://localhost:5432/nba_beta"
		}
	}
	test {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			//url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			url = "jdbc:postgresql://10.247.55.40:5432/nba_test"

			
			}
	}
	production {	
		dataSource {
			dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
			//url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			
			// for live/production server
			
//    		url = "jdbc:postgresql://10.247.55.40:5432/nba"

			// for NBA test server
           url = "jdbc:postgresql://10.247.55.40:5432/nba_test"
			 
 // for staging server sudhir
			 
//	     	url = "jdbc:postgresql://10.25.121.245:5432/phase2"
//			url = "jdbc:postgresql://10.153.74.70:5432/phase2"
			 
			properties {
			   // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
			}
		}
	}
}