package com.oks.web.app.all.be.config.cache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class CacheLogger implements CacheEventListener<Object, Object> {

  private final Logger LOG = LogManager.getLogger(CacheLogger.class);

  @Override
  public void onEvent(CacheEvent<?, ?> cacheEvent) {
    LOG.info("Key: {} | EventType: {} | Old value: {} | New value: {}",
             cacheEvent.getKey(), cacheEvent.getType(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
  }

}
