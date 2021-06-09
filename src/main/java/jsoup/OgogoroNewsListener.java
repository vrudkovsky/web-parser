package jsoup;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class OgogoroNewsListener extends WebSocketClient {

    private static final Logger log = LoggerFactory.getLogger(OgogoroNewsListener.class);

    public OgogoroNewsListener(String url) throws URISyntaxException{
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        log.info("Opened connection!");

        //Send action to receive live news
        send("{action: \"getnews\"}");

        log.info("Sent action to get live news!");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        log.error("An error occured: ", ex);
    }
}
