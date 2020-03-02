package pt.ulisboa.tecnico.distsys.ttt.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "game" path)
 */
@Path("game")
public class TTTResources {
	
	/**
	 * 
	 * TTTGame currently being played
	 * 
	 */
	static TTTGame game = new TTTGame();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Board that will be returned as a text/plain response.
     */ 
    @GET
    @Path("board")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBoard() {
    	return game.toString();
    }
    
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Board that will be returned as a text/plain response.
     */ 
    @GET
    @Path("board/reset")
    @Produces(MediaType.TEXT_PLAIN)
    public String resetBoard() {
        game.resetBoard();
        return game.toString();
    }
    
    
    /* TODO: checkwinner, play */
}
