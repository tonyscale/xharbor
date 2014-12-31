/**
 * 
 */
package org.jocean.httpgateway.impl;

import io.netty.channel.ChannelHandlerContext;

import org.jocean.event.api.EventReceiverSource;
import org.jocean.httpclient.HttpStack;
import org.jocean.httpgateway.biz.RelayAgent;
import org.jocean.httpgateway.biz.HttpDispatcher.RelayContext;

/**
 * @author isdom
 *
 */
public class RelayAgentImpl implements RelayAgent {
    public RelayAgentImpl(final HttpStack httpStack, final EventReceiverSource source) {
        this._stack = httpStack;
        this._source = source;
    }
    
    @Override
    public RelayTask createRelayTask(
            final RelayContext relay,
            final ChannelHandlerContext ctx) {
        final RelayFlow flow = 
                new RelayFlow(this._stack, relay, ctx);
        
        this._source.create(flow, flow.WAIT);
        
        return flow.queryInterfaceInstance(RelayTask.class);
    }

    private final HttpStack _stack;
    private final EventReceiverSource _source;
}