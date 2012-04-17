AUI().ready(
	'aui-io-request',
	function(A) {
		var body = A.getBody();

		var toggleFluid = A.one('#toggleFluid');

		if (toggleFluid) {
			toggleFluid.on(
				'click',
				function (event) {
					if (!body.hasClass('so-layout-fluid-ad')) {
						body.toggleClass('so-layout-fluid');

						A.io.request(
							themeDisplay.getPathMain() + '/portal/session_click',
							{
								data: {
									'so-layout-fluid': body.hasClass('so-layout-fluid')
								}
							}
						);
					};
				}
			);
		}
	}
);