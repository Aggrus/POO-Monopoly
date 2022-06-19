package model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Controller.Observer.Observable;
import Controller.Observer.Observer;
import Controller.Observer.PlayerObserver;
import enums.PlayerColorEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 8, 2022
 */
class Player
	implements Observable
{

	public Player()
	{
		this.money = Long.valueOf( 4000 );
		this.inGame = true;
		this.boardPosition = 11;
		this.inPrision = false;
		this.prisionTime = 0;
		this.roundTrips = 0;
		this.freeRide = false;
	}

	public Player( final PlayerColorEnum color )
	{
		this.color = color;
		this.money = Long.valueOf( 4000 );
		this.inGame = true;
		this.boardPosition = 0;
		this.inPrision = false;
		this.prisionTime = 0;
		this.roundTrips = 0;
		this.freeRide = false;
	}

	@Override
	public void add( final Observer o )
	{
		this.observer.add( ( PlayerObserver ) o );
		this.observer.get( this.observer.size() - 1 ).notifyFreeRide( this.freeRide );
		this.observer.get( this.observer.size() - 1 ).notifyInPrision( this.inPrision );
		this.observer.get( this.observer.size() - 1 ).nofityBoardPosition( this.boardPosition );
		this.observer.get( this.observer.size() - 1 ).nofityColor( this.color );
		this.observer.get( this.observer.size() - 1 ).notifyMoney( this.money );
		this.observer.get( this.observer.size() - 1 ).notifyPrisionTime( this.prisionTime );
		this.observer.get( this.observer.size() - 1 ).notifyRoundTrips( this.roundTrips );
	}

	public void addPriosionTime()
	{
		this.prisionTime++;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the boardPosition.
	 * @see #boardPosition
	 */
	public Integer getBoardPosition()
	{
		return this.boardPosition;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the color.
	 * @see #color
	 */
	public PlayerColorEnum getColor()
	{
		return this.color;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the money.
	 * @see #money
	 */
	public Long getMoney()
	{
		return this.money;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the prisionTime.
	 * @see #prisionTime
	 */
	public Integer getPrisionTime()
	{
		return this.prisionTime;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the roundTrips.
	 * @see #roundTrips
	 */
	public Integer getRoundTrips()
	{
		return this.roundTrips;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the freeRide.
	 * @see #freeRide
	 */
	public boolean isFreeRide()
	{
		return this.freeRide;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the inGame.
	 * @see #inGame
	 */
	public boolean isInGame()
	{
		return this.inGame;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the inPriosion.
	 * @see #inPrision
	 */
	public boolean isInPrision()
	{
		return this.inPrision;
	}

	public void loseMoney( final Long amount )
	{
		setMoney( getMoney() - amount );
		playerStatus();
		if ( !isInGame() )
		{
			Game.getPlayerList().remove( this );
		}
	}

	public void playerStatus()
	{
		while (getMoney() <= 0 && isInGame())
		{
			if (hasTile())
			{
				forcedSale();
			}
			else
			{
				setInGame( false );
			}
		}
	}

	public boolean hasTile()
	{
		return Game.getTiles().stream().anyMatch(tile -> tile.getOwner().equals(this));
	}

	private void forcedSale()
	{
		List<AbstractTile> ownedTiles = Game.getTiles().stream().filter(tile -> tile.getOwner().equals(this)).collect(Collectors.toList());
		List<AbstractTile> ownedProperties = ownedTiles.stream().filter(tile -> tile.getGorup() != null).collect(Collectors.toList());
		List<AbstractTile> tilesWithBuildings = ownedProperties.stream().filter(tile -> ((Property)tile).getBuildings().size() > 0).collect(Collectors.toList());
		if (tilesWithBuildings.size() > 0)
		{
			Long max = (long)0;
			Property maxBuildingCostTile = null;
			for (AbstractTile tile : tilesWithBuildings)
			{
				Property property = ((Property)tile);
				if (property.getBuildingValue() > max)
				{
					max = property.getBuildingValue();
					maxBuildingCostTile = new Property(property);
				}
			}
			loseMoney( -maxBuildingCostTile.sellBuilding());
		}
		else if (tilesWithBuildings.size() == 0)
		{
			Long max = (long)0;
			CompanyTile maxCostTile = null;
			for (AbstractTile tile : tilesWithBuildings)
			{
				CompanyTile company = ((CompanyTile)tile);
				if (company.getValue() > max)
				{
					max = company.getValue();
					maxCostTile = new CompanyTile(company);
				}
			}
			loseMoney( -maxCostTile.getValue());
			tilesWithBuildings.get(maxCostTile.getBoardPosition()).setCanPurchase(true);
			tilesWithBuildings.get(maxCostTile.getBoardPosition()).setOwner(null);
		}
		else
		{
			Long max = (long)0;
			Property maxCostTile = null;
			for (AbstractTile tile : tilesWithBuildings)
			{
				Property property = ((Property)tile);
				if (property.getValue() > max)
				{
					max = property.getValue();
					maxCostTile = new Property(property);
				}
			}
			loseMoney( -maxCostTile.getValue());
			tilesWithBuildings.get(maxCostTile.getBoardPosition()).setCanPurchase(true);
			tilesWithBuildings.get(maxCostTile.getBoardPosition()).setOwner(null);
		}
	}

	@Override
	public void remove( final Observer o )
	{
		this.observer.remove( o );
	}

	public void resetPrisionTime()
	{
		this.prisionTime = 0;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param boardPosition
	 *            The boardPosition to set.
	 * @see #boardPosition
	 */
	public void setBoardPosition( final Integer boardPosition )
	{
		this.boardPosition = boardPosition;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param color
	 *            The color to set.
	 * @see #color
	 */
	public void setColor( final PlayerColorEnum color )
	{
		this.color = color;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param freeRide
	 *            The freeRide to set.
	 * @see #freeRide
	 */
	public void setFreeRide( final boolean freeRide )
	{
		this.freeRide = freeRide;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param inGame
	 *            The inGame to set.
	 * @see #inGame
	 */
	private void setInGame( final boolean inGame )
	{
		this.inGame = inGame;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param inPriosion
	 *            The inPriosion to set.
	 * @see #inPrision
	 */
	public void setInPrision( final boolean inPriosion )
	{
		this.inPrision = inPriosion;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param money
	 *            The money to set.
	 * @see #money
	 */
	public void setMoney( final Long money )
	{
		this.money = money;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param roundTrips
	 *            The roundTrips to set.
	 * @see #roundTrips
	 */
	public void setRoundTrips( final Integer roundTrips )
	{
		this.roundTrips = roundTrips;
	}

	@Override
	public void update( final Observer o )
	{
		final Optional<PlayerObserver> observerFromList = this.observer
			.stream()
			.filter( obs -> obs.equals( o ) )
			.findAny();
		if ( observerFromList.isPresent() )
		{
			observerFromList.get().notifyFreeRide( this.freeRide );
			observerFromList.get().notifyInPrision( this.inPrision );
			observerFromList.get().nofityBoardPosition( this.boardPosition );
			observerFromList.get().nofityColor( this.color );
			observerFromList.get().notifyMoney( this.money );
			observerFromList.get().notifyPrisionTime( this.prisionTime );
			observerFromList.get().notifyRoundTrips( this.roundTrips );
		}

	}

	private Integer boardPosition;

	private PlayerColorEnum color;

	private boolean freeRide;

	private boolean inGame;

	private boolean inPrision;

	private Long money;

	private List<PlayerObserver> observer;

	private Integer prisionTime;

	private Integer roundTrips;

}
