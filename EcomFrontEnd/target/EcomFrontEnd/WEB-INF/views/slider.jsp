<script
	src="https://jssors8.azureedge.net/script/jssor.slider-27.5.0.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	jssor_1_slider_init = function() {

		var jssor_1_SlideshowTransitions = [ {
			$Duration : 800,
			x : -0.3,
			$SlideOut : true,
			$Easing : {
				$Left : $Jease$.$InCubic,
				$Opacity : $Jease$.$Linear
			},
			$Opacity : 2
		}, {
			$Duration : 600,
			$Delay : 20,
			$Cols : 8,
			$Rows : 4,
			$Formation : $JssorSlideshowFormations$.$FormationZigZag,
			$Assembly : 260,
			$Opacity : 2
		}, {
			$Duration : 1000,
			x : 1,
			$Rows : 2,
			$ChessMode : {
				$Row : 3
			},
			$Easing : {
				$Left : $Jease$.$InOutQuart,
				$Opacity : $Jease$.$Linear
			},
			$Opacity : 2,
			$Brother : {
				$Duration : 1000,
				x : -1,
				$Rows : 2,
				$ChessMode : {
					$Row : 3
				},
				$Easing : {
					$Left : $Jease$.$InOutQuart,
					$Opacity : $Jease$.$Linear
				},
				$Opacity : 2
			}
		}, {
			$Duration : 1200,
			$Zoom : 11,
			$Rotate : 1,
			$Easing : {
				$Zoom : $Jease$.$InCubic,
				$Opacity : $Jease$.$OutQuad,
				$Rotate : $Jease$.$InCubic
			},
			$Opacity : 2,
			$Round : {
				$Rotate : 0.7
			}
		}, {
			$Duration : 1200,
			x : 0.5,
			$Cols : 2,
			$Zoom : 1,
			$SlideOut : true,
			$Assembly : 2049,
			$ChessMode : {
				$Column : 15
			},
			$Easing : {
				$Left : $Jease$.$InExpo,
				$Zoom : $Jease$.$InExpo,
				$Opacity : $Jease$.$Linear
			},
			$Opacity : 2
		}, {
			$Duration : 500,
			$Delay : 40,
			$Cols : 10,
			$Rows : 5,
			$Opacity : 2,
			$Clip : 15,
			$SlideOut : true,
			$Easing : $Jease$.$OutQuad
		} ];

		var jssor_1_options = {
			$AutoPlay : 1,
			$SlideshowOptions : {
				$Class : $JssorSlideshowRunner$,
				$Transitions : jssor_1_SlideshowTransitions,
				$TransitionsOrder : 1
			},
			$ArrowNavigatorOptions : {
				$Class : $JssorArrowNavigator$
			},
			$BulletNavigatorOptions : {
				$Class : $JssorBulletNavigator$
			}
		};

		var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

		/*#region responsive code begin*/

		var MAX_WIDTH = 15020;

		function ScaleSlider() {
			var containerElement = jssor_1_slider.$Elmt.parentNode;
			var containerWidth = containerElement.clientWidth;

			if (containerWidth) {

				var expectedWidth = Math.min(MAX_WIDTH || containerWidth,
						containerWidth);

				jssor_1_slider.$ScaleWidth(expectedWidth);
			} else {
				window.setTimeout(ScaleSlider, 30);
			}
		}

		ScaleSlider();

		$Jssor$.$AddEvent(window, "load", ScaleSlider);
		$Jssor$.$AddEvent(window, "resize", ScaleSlider);
		$Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);
		/*#endregion responsive code end*/
	};
</script>
<style>
/*jssor slider loading skin spin css*/
.jssorl-009-spin img {
	animation-name: jssorl-009-spin;
	animation-duration: 1.6s;
	animation-iteration-count: infinite;
	animation-timing-function: linear;
}

@
keyframes jssorl-009-spin {from { transform:rotate(0deg);
	
}

to {
	transform: rotate(360deg);
}

}

/*jssor slider bullet skin 035 css*/
.jssorb035 {
	position: absolute;
}

.jssorb035 .i {
	position: absolute;
	cursor: pointer;
}

.jssorb035 .i .b {
	fill: #000;
	fill-opacity: 0.5;
	stroke: #fff;
	stroke-width: 1200;
	stroke-miterlimit: 10;
	stroke-opacity: 0.3;
}

.jssorb035 .i:hover .b {
	fill: #fff;
	fill-opacity: .7;
	stroke: #000;
	stroke-opacity: .5;
}

.jssorb035 .iav .b {
	fill: #fff;
	stroke: #000;
	fill-opacity: 1;
}

.jssorb035 .i.idn {
	opacity: .3;
}

/*jssor slider arrow skin 093 css*/
.jssora093 {
	display: block;
	position: absolute;
	cursor: pointer;
}

.jssora093 .c {
	fill: none;
	stroke: #fff;
	stroke-width: 400;
	stroke-miterlimit: 10;
}

.jssora093 .a {
	fill: none;
	stroke: #fff;
	stroke-width: 400;
	stroke-miterlimit: 10;
}

.jssora093:hover {
	opacity: .8;
}

.jssora093.jssora093dn {
	opacity: .6;
}

.jssora093.jssora093ds {
	opacity: .3;
	pointer-events: none;
}
</style>
<div id="jssor_1"
	style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 980px; height: 380px; overflow: hidden; visibility: hidden;">
	<!-- Loading Screen -->
	<div data-u="loading" class="jssorl-009-spin"
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; text-align: center; background-color: rgba(0, 0, 0, 0.7);">
		<img
			style="margin-top: -19px; position: relative; top: 50%; width: 38px; height: 38px;"
			src="//jssorcdn7.azureedge.net/theme/svg/loading/static-svg/spin.svg" />
	</div>
	<div data-u="slides"
		style="cursor: default; position: relative; top: 0px; left: 0px; width: 980px; height: 380px; overflow: hidden;">
		<div>
			<img data-u="image" src="resources\images\image11.png" />
		</div>
		<div>
			<img data-u="image" src="resources\images\image10.png" />
		</div>
		<div>
			<img data-u="image" src="resources\images\image13.png" />
		</div>
		<div>
			<img data-u="image" src="resources\images\images3.png" />
		</div>
		<div>
			<img data-u="image" src="resources\images\image4.png" />
		</div>
		<div>
			<img data-u="image" src="resources\images\image6.png" />
		</div>
		<div>
			<img data-u="image" src="resources\images\image7.png" />
		</div>
	</div>
	<!-- Bullet Navigator -->
	<div data-u="navigator" class="jssorb035"
		style="position: absolute; bottom: 12px; right: 12px;"
		data-autocenter="1" data-scale="0.5" data-scale-bottom="0.75">
		<div data-u="prototype" class="i" style="width: 16px; height: 16px;">
			<svg viewbox="0 0 16000 16000"
				style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
                    <rect class="b" x="2200" y="2200" width="11600"
					height="11600"></rect>
                </svg>
		</div>
	</div>
	<!-- Arrow Navigator -->
	<div data-u="arrowleft" class="jssora093"
		style="width: 50px; height: 50px; top: 0px; left: 30px;"
		data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
		<svg viewbox="0 0 16000 16000"
			style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
                <circle class="c" cx="8000" cy="8000" r="5920"></circle>
                <polyline class="a"
				points="7777.8,6080 5857.8,8000 7777.8,9920 "></polyline>
                <line class="a" x1="10142.2" y1="8000" x2="5857.8"
				y2="8000"></line>
            </svg>
	</div>
	<div data-u="arrowright" class="jssora093"
		style="width: 50px; height: 50px; top: 0px; right: 30px;"
		data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
		<svg viewbox="0 0 16000 16000"
			style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
                <circle class="c" cx="8000" cy="8000" r="5920"></circle>
                <polyline class="a"
				points="8222.2,6080 10142.2,8000 8222.2,9920 "></polyline>
                <line class="a" x1="5857.8" y1="8000" x2="10142.2"
				y2="8000"></line>
            </svg>
	</div>
</div>
<script type="text/javascript">
	jssor_1_slider_init();
</script>