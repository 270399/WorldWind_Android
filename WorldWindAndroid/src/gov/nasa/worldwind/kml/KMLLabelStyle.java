/*
 * Copyright (C) 2012 DreamHammer.com
 */

package gov.nasa.worldwind.kml;

/**
 * Represents the KML <i>LabelStyle</i> element and provides access to its contents.
 *
 * @author tag
 * @version $Id: KMLLabelStyle.java 771 2012-09-14 19:30:10Z tgaskins $
 */
public class KMLLabelStyle extends KMLAbstractColorStyle
{
    /**
     * Construct an instance.
     *
     * @param namespaceURI the qualifying namespace URI. May be null to indicate no namespace qualification.
     */
    public KMLLabelStyle(String namespaceURI)
    {
        super(namespaceURI);
    }

    public Double getScale()
    {
        return (Double) this.getField("scale");
    }
}
