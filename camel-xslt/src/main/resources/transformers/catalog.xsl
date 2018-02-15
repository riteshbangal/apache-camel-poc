<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:output method="html" indent="yes" version="4.0" />
	<xsl:template match="/">
		<html>
			<body>
				<xsl:for-each select="catalog/cd">
					<xsl:value-of select="title"/>
					<xsl:value-of select="artist"/>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>