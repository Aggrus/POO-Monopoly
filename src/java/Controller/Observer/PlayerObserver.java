package Controller.Observer;

import enums.PlayerColorEnum;

public interface PlayerObserver extends Observer
{
    public void nofityBoardPosition(Integer boardPosition,  Integer playerId);
    //public void notifyFreeRide(boolean freeRide,  Integer playerId);
    public void notifyMoney(Long money,  Integer playerId);
    public void notifyPrisionTime(Integer prisionTime,  Integer playerId);
	//private boolean inGame needed?
}
