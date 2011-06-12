package com.fasterxml.cachemate;

/**
 * Entry for caches that can be accessed both by using the primary
 * key and an optional secondary key.
 */
public interface TwoKeyCacheElement<K1, K2, V>
    extends CacheElement<K1, V>
{
    /*
    /**********************************************************************
    /* Co-variant versions of methods from CacheElement
    /**********************************************************************
     */

    @Override
    public TwoKeyCacheEntry<K1, K2, V> putEntry(long currentTime, K1 key, V value, int weight);

    @Override
    public TwoKeyCacheEntry<K1, K2, V> putEntry(long currentTime, K1 key, int keyHash,
            V value, int weight);
    
    @Override
    public TwoKeyCacheEntry<K1, K2, V> findEntry(long currentTime, K1 key);

    @Override
    public TwoKeyCacheEntry<K1, K2, V> findEntry(long currentTime, K1 key, int keyHash);

    @Override
    public TwoKeyCacheEntry<K1, K2, V> removeEntry(long currentTime, K1 key);

    @Override
    public TwoKeyCacheEntry<K1, K2, V> removeEntry(long currentTime, K1 key, int keyHash);
    
    /*
    /**********************************************************************
    /* Addditional methods using secondary key
    /**********************************************************************
     */

    public TwoKeyCacheEntry<K1, K2, V> putEntry(long currentTime, K1 primaryKey, K2 secondaryKey, V value, int weight);
    public TwoKeyCacheEntry<K1, K2, V> putEntry(long currentTime, K1 primaryKey, int primaryKeyHash,
            K2 secondaryKey, int secondaryKeyHash,
            V value, int weight);
    
    public TwoKeyCacheEntry<K1, K2, V> findEntryBySecondary(long currentTime, K2 secondaryKey);
    public TwoKeyCacheEntry<K1, K2, V> findEntryBySecondary(long currentTime, K2 secondaryKey, int keyHash);

    public TwoKeyCacheEntry<K1, K2, V> removeEntryBySecondary(long currentTime, K2 secondaryKey);
    public TwoKeyCacheEntry<K1, K2, V> removeEntryBySecondary(long currentTime, K2 secondaryKey, int secondaryKeyHash);
}