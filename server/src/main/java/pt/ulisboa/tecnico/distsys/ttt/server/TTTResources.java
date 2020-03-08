package pt.ulisboa.tecnico.distsys.ttt.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.ulisboa.tecnico.distsys.ttt.contract.PlayRequest;
import pt.ulisboa.tecnico.distsys.ttt.contract.PlayResult;

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
    @GET
    @Path("board/checkwinner")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkWinner() {
        int winner = game.checkWinner();
        return Integer.toString(winner);
    }

    @POST
    @Path("play")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public PlayResult play(PlayRequest playRequest) {
        return game.play(playRequest.getRow(), playRequest.getColumn(), playRequest.getPlayer());
    }
}
