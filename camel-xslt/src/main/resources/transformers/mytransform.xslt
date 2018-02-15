<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" type="text/css" href="style.css">
    <xsl:template match="/">
        <rentalProperties>
            <property>
                <xsl:attribute name="contact"><xsl:value-of select='@contact'/></xsl:attribute>    
                <type><xsl:value-of select="proptype"/></type>
                <price><xsl:value-of select="price"/></price>
                <numberOfBedrooms><xsl:value-of select="numberOfBedrooms"/></numberOfBedrooms>
                <numberOfBathrooms><xsl:value-of select="numberOfBathrooms"/></numberOfBathrooms>
                <garage><xsl:value-of select="garage"/></garage>    
            </property>    
        </rentalProperties>    
    </xsl:template>
</xsl:stylesheet>