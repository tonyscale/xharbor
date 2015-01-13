/**
 * 
 */
package org.jocean.xharbor.spi;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;

import org.jocean.event.api.annotation.GuardPaired;
import org.jocean.idiom.Detachable;

/**
 * @author isdom
 *
 */
public interface RelayAgent<RELAYCTX> {
    public interface RelayTask extends Detachable {
        @GuardPaired(paired={"org.jocean.netty.NettyUtils._NETTY_REFCOUNTED_GUARD"})
        public void sendHttpRequest(final HttpRequest httpRequest);
        
        @GuardPaired(paired={"org.jocean.netty.NettyUtils._NETTY_REFCOUNTED_GUARD"})
        public void sendHttpContent(final HttpContent httpContent);
    }
    
    public RelayTask createRelayTask(final RELAYCTX relayCtx, final ChannelHandlerContext channelCtx);
}