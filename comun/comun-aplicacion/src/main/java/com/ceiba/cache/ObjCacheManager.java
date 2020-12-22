package com.ceiba.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

public class ObjCacheManager {

	private CacheManager cacheManager;

	private Cache cache;

	private static final String CACHE_APP = "paramscache";

	public ObjCacheManager() {
		cacheManager = CacheManager.create();

		cache = cacheManager.getCache(CACHE_APP);
		if (cache == null) {
			cache = new Cache(new CacheConfiguration(CACHE_APP, 1000)
					.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LRU).eternal(true).timeToIdleSeconds(0)
					.diskExpiryThreadIntervalSeconds(0).persistence(
							new PersistenceConfiguration().strategy(PersistenceConfiguration.Strategy.LOCALTEMPSWAP)));
			cache.disableDynamicFeatures();
			cacheManager.addCache(this.cache);
		}
	}

	public void clearCache() {
		cacheManager.removeAllCaches();
	}

	public void putInCache(Integer key, Object value) {
		try {
			cache.put(new Element(key, value));
		} catch (CacheException e) {
			throw new CacheException(String.format("Problem occurred while putting data into cache: %s", e.getMessage()));
		}
	}

	public Object retrieveFromCache(Integer key) {
		try {
			Element element = cache.get(key);
			if (element != null)
				return element.getObjectValue();
		} catch (CacheException ce) {
			throw new CacheException(String.format("Problem occurred while trying to retrieveSpecific from cache: %s", ce.getMessage()));
		}
		return null;
	}
}
