import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint("/websock")
public class Websock extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        RemoteEndpoint.Basic remoteEndpointBasic = session.getBasicRemote();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        try {
            while (true) {
                Thread.sleep(2000L);
                String e = simpleDateFormat.format(new Date());
                remoteEndpointBasic.sendText(e);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
