package model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import Exception.IllegalRuleException;
import Exception.WrongPlayerException;
import enums.BuildingEnum;
import enums.TileColorEnum;
import enums.TileEnum;

/**
 * <p>
 * </p>
 *
 * @author gugaz
 * @version 1.0 Created on May 17, 2022
 */
class Property
	extends AbstractTile
{

	public Property()
	{
		setSpecialProperty( TileEnum.NONE );
		setCanPurchase( true );
		setOwner( null );
	}

	public Property( final Long rent, final TileColorEnum color, final Long[] rentIncreases )
	{
		setRentIncreases( rentIncreases );
		setGorup( color );
		setRent( rent );
		setCanPurchase( true );
	}

	private void addBuilding( final Player player, final Building building )
		throws WrongPlayerException
	{
		if ( getOwner().equals( player ) )
		{
			if ( checkAddBuilding( building ) )
			{
				this.buildings.add( building );
			}
			else
			{
				throw new IllegalRuleException( "Property owner does not own all properties of this group!" );
			}
		}
		else
		{
			throw new WrongPlayerException();
		}
		increaseRent();
	}

	public boolean buyBuilding( final Player player, final Building building )
	{
		try
		{
			addBuilding( player, building );
		}
		catch ( final WrongPlayerException e )
		{
			return false;
		}
		player.loseMoney( building.getPrice() );
		return true;

	}

	public void buyProperty( final Player player )
		throws IllegalRuleException
	{
		if ( null != getOwner() )
		{
			throw new IllegalRuleException( "Propriedade já tem dono!" );
		}
		player.loseMoney( getValue() );
		setOwner( player );

	}

	private boolean canBuild()
	{
		final Stream<AbstractTile> thisGroup = Game
			.getTiles()
			.stream()
			.filter( t -> t.getGorup().equals( getGorup() ) );
		return thisGroup.allMatch( t -> getBuildings().size() <= ( ( Property ) t ).getBuildings().size() );
	}

	private boolean canBuildHotel()
	{

		return ( ( getBuildings().size() > 1 ) && !hasHotel() );
	}

	private boolean checkAddBuilding( final Building building )
		throws IllegalRuleException
	{
		boolean canAddBuilding = canBuild() && checkGroupOwner();
		if ( building.getBuildingType().equals( BuildingEnum.HOTEL ) )
		{
			if ( !canBuildHotel() )
			{
				canAddBuilding = canAddBuilding && canBuildHotel();
			}
		}
		else
		{
			throw new IllegalRuleException( "Não pode adicionar construção!" );
		}
		return canAddBuilding;
	}

	private boolean checkGroupOwner()
	{
		final Player owner = getOwner();
		final Stream<AbstractTile> thisGroup = Game
			.getTiles()
			.stream()
			.filter( t -> t.getGorup().equals( getGorup() ) );
		;

		return ( thisGroup.allMatch( t -> t.getOwner().equals( owner ) ) );
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the buildings.
	 * @see #buildings
	 */
	public List<Building> getBuildings()
	{
		return this.buildings;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the rent.
	 * @see #rent
	 */
	public Long getRent()
	{
		return this.rent;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the rentIncreases.
	 * @see #rentIncreases
	 */
	public Long[] getRentIncreases()
	{
		return this.rentIncreases;
	}

	private boolean hasHotel()
	{
		return getBuildings().stream().anyMatch( t -> t.getBuildingType().equals( BuildingEnum.HOTEL ) );
	}

	private void increaseRent()
	{
		if ( null == getBuildings() )
		{
			throw new IllegalStateException();
		}
		setRent( this.rentIncreases[getBuildings().size() - 1] );
	}

	public void removeBuilding( final Integer buildId )
	{
		final Optional<Building> building = this.buildings
			.stream()
			.filter( b -> b.getId().equals( buildId ) )
			.findFirst();

		if ( building.isPresent() )
		{
			this.buildings.remove( building.get() );
		}
		else
		{
			throw new NullPointerException( "Ineteger expected, recieved null" );
		}
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param rent
	 *            The rent to set.
	 * @see #rent
	 */
	private void setRent( final Long rent )
	{
		this.rent = rent;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param rentIncreases2
	 *            The rentIncreases to set.
	 * @see #rentIncreases
	 */
	private void setRentIncreases( final Long[] rentIncreases2 )
	{
		this.rentIncreases = rentIncreases2;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param player
	 * @see model.AbstractTile#tileRule(model.Player)
	 */
	@Override
	public void tileRule( final Player player )
	{
		if ( !player.equals( getOwner() ) )
		{
			player.loseMoney( getRent() );
		}
	}

	private List<Building> buildings;

	private Long rent;

	private Long[] rentIncreases;

}
