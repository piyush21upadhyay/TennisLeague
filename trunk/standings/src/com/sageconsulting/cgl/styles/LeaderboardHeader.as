package com.sageconsulting.cgl.styles
{
	import mx.skins.halo.DataGridHeaderBackgroundSkin;
	import flash.geom.Matrix;

	public class LeaderboardHeader extends DataGridHeaderBackgroundSkin
	{
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
		{
			//super.updateDisplayList(unscaledWidth, unscaledHeight);

			var bgColor:int = getStyle("headerBackgroundColor");
			var txtColor:int = getStyle("headerTextColor");
			graphics.clear();
			graphics.beginFill(0x080800);
			graphics.drawRect(0, 0, unscaledWidth, unscaledHeight);
			graphics.endFill();
			
			graphics.beginFill(0xb7babc);
			graphics.drawRoundRect(0, 0, unscaledWidth, unscaledHeight, 10, 10);
			graphics.endFill();
			
			var fillColors:Array = [0x6B757B, 0x000000];
			var fillAlphas:Array = [0.5, 0.5];
			var gradientType:String = "linear";
			var angle:Number = 90;
			var focalPointRatio:Number = 0.5;
			var matrix:Matrix = new Matrix();
			matrix.createGradientBox(unscaledWidth-2, unscaledHeight-2, angle * Math.PI / 180);
			
			graphics.beginGradientFill(gradientType, fillColors, fillAlphas, [0, 255] , matrix, "pad", "rgb", focalPointRatio);
			graphics.drawRoundRect(1, 1, unscaledWidth-2, unscaledHeight-2, 10, 10);
			graphics.endFill();
		}
	}
}