/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;

import org.eclipse.collections.api.block.procedure.Procedure;

/**
 * A ConcurrentMutableMap provides an api which combines and supports both MutableMap and ConcurrentMap.
 */
public interface ConcurrentMutableMap<K, V>
        extends MutableMap<K, V>, ConcurrentMap<K, V>
{
    @Override
    ConcurrentMutableMap<K, V> tap(Procedure<? super V> procedure);

    @Override
    default V getOrDefault(Object key, V defaultValue)
    {
        return this.getIfAbsentValue((K) key, defaultValue);
    }

    @Override
    default ConcurrentMutableMap<K, V> withMap(Map<? extends K, ? extends V> map)
    {
        this.putAll(map);
        return this;
    }

    @Override
    default ConcurrentMutableMap<K, V> withMapIterable(MapIterable<? extends K, ? extends V> mapIterable)
    {
        this.putAllMapIterable(mapIterable);
        return this;
    }

    @Override
    default void forEach(BiConsumer<? super K, ? super V> action)
    {
        MutableMap.super.forEach(action);
    }
}
