package com.sageconsulting.cgl.styles
{
	import mx.skins.RectangularBorder;

	public class FinalsBorder extends RectangularBorder
	{
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void 
        {
        	super.updateDisplayList(unscaledWidth, unscaledHeight);
        	
        	var borderPosition:String = getStyle("borderPosition");
        	var borderColor:int = getStyle("borderColor");
        	var borderLength:int = getStyle("borderLength");
        	graphics.clear();
        	
        	graphics.lineStyle(1, borderColor);
        	if (borderPosition == "left")
        	{
	        	graphics.moveTo(0, unscaledHeight);
	        	graphics.lineTo(borderLength, unscaledHeight);
        	}
        	else
        	{
	        	graphics.moveTo(unscaledWidth, unscaledHeight);
	        	graphics.lineTo(unscaledWidth-borderLength, unscaledHeight);
        	}
		}
	}
}