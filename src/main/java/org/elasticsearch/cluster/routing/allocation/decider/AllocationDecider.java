/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.cluster.routing.allocation.decider;

import org.elasticsearch.cluster.routing.RoutingNode;
import org.elasticsearch.cluster.routing.ShardRouting;
import org.elasticsearch.cluster.routing.allocation.RoutingAllocation;
import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.settings.Settings;

/**
 * A pluggable logic allowing to control if allocation of a shard is allowed on a specific node.
 */
public abstract class AllocationDecider extends AbstractComponent {

    protected AllocationDecider(Settings settings) {
        super(settings);
    }

    /**
     * Are we allowed to rebalance this shard?
     */
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        return Decision.ALWAYS;
    }

    /**
     * Can the provided shard routing be allocated on the node.
     */
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        return Decision.ALWAYS;
    }

    /**
     * Can the provided shard routing remain on the node?
     */
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        return Decision.ALWAYS;
    }
}
