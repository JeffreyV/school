package be.xios.ladadv.portfolio.opdracht1;

import java.awt.Color;

public class Koning
{
    private String naam;
    private Color  kleur;
    private String kado;

    public Koning( String naam )
    {
	super();
	this.naam = naam;
    }

    public Koning( Color kleur )
    {
	super();
	this.kleur = kleur;
    }

    public Koning( String naam, Color kleur )
    {
	super();
	this.naam = naam;
	this.kleur = kleur;
    }

    public String getNaam()
    {
	return naam;
    }

    public void setNaam( String naam )
    {
	this.naam = naam;
    }

    public Color getKleur()
    {
	return kleur;
    }

    public void setKleur( Color kleur )
    {
	this.kleur = kleur;
    }

    public String getKado()
    {
	return kado;
    }

    public void setKado( String kado )
    {
	this.kado = kado;
    }

    @Override
    public String toString()
    {
	if (this.naam != null)
	{
	    return String.format( "%s, de %s koning gaf %s", this.naam,
		    this.kleur, this.kado );
	}
	else
	{
	    return "Koning heeft nog geen naam";
	}
    }
}
