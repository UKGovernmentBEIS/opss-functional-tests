Feature: Add team admin users in keycloack
  
@new-group
Scenario Outline: Add new groups and teams in kc
   Given I login as keycloack Admin user
   When I go to groups
   And I click new
   Then I should be able to create new group "<group-name>"
   And I should be abel to create new team "<group-name>"
   And I add group email box "<email-box>"
   Examples:
  |group-name														   |email-box																	 |
  |Richmond, Merton and Wandsworth Borough |trading.standards@merton.gov.uk          	 |
	|Royal Borough of Kensington and Chelsea |trading.standards@rbkc.gov.uk         		 |
	|Royal Borough of Kingston upon Thames   |trading.standards@kingston.gov.uk    			 |
	|London Borough of Waltham Forest				 |trading.standards@walthamforest.gov.uk		 |
	|London Borough of Tower Hamlets         |tradingstandards@towerhamlets.gov.uk			 |
	|Barking and Dagenham Borough						 |tradingstandards@lbbd.gov.uk							 |
	|Hammersmith & Fulham Borough						 |trading.standards@lbhf.gov.uk							 |
	|London Borough of Hillingdon						 |tradingstandards@hillingdon.gov.uk				 |
	|London Borough of Islington						 |trading.standards@islington.gov.uk				 |
	|London Borough of Redbridge						 |tradingstandards&licensing@redbridge.gov.uk|
	|London Borough of Southwark						 |tradingstandards@southwark.gov.uk					 |
	|London Borough of Haringey							 |frontline@haringey.gov.uk									 |
	|London Borough of Havering 						 |trading.standards@havering.gov.uk					 |
	|London Borough of Hounslow							 |tradingstandards@hounslow.gov.uk|
	|London Borough of Lewisham|cer@lewisham.gov.uk|
	|Royal Borough of Greenwich|tradingstandards@royalgreenwich.gov.uk|
	|London Borough of Bromley|trading.standards@bromley.gov.uk|
	|London Borough of Croydon|trading.standards@croydon.gov.uk|
	|London Borough of Enfield|trading.standards@enfield.gov.uk|
	|London Borough of Hackney|trading.standards@hackney.gov.uk|
	|London Borough of Lambeth|tradingstandards@lambeth.gov.uk|
	|London Borough of Barnet|trading.standards@barnet.gov.uk|
	|London Borough of Bexley|ts.duty@bexley.gov.uk|
	|London Borough of Camden|tradingstandards@camden.gov.uk|
	|London Borough of Ealing|tradingstandards@ealing.gov.uk|
	|London Borough of Newham|TradingStandard@newham.gov.uk|
	|London Borough of Sutton|trading.standards@sutton.gov.uk|
	|London Borough of Brent|trading.standards@brent.gov.uk|
	|City of Westminster|tradingstandards@westminster.gov.uk|
	|City of London|TradingStandards@cityoflondon.gov.uk|
	|South Tyneside Metropolitan Borough Council|Trading.standards@southtyneside.gov.uk|
	|Gateshead Metropolitan Borough Council|tradingstandards@gateshead.gov.uk|
	|Redcar & Cleveland Borough Council|consumeradvice@redcar-cleveland.gov.uk|
	|Stockton-on-Tees Borough Council|trading.standards@stockton.gov.uk|
	|Newcastle upon Tyne City Council|tradingstandards@newcastle.gov.uk|
	|Northumberland County Council|tradingstandards@northumberland.gov.uk|
	|Middlesbrough Borough Council|EHTS@middlesbrough.gov.uk|
	|Darlington Borough Council|tradingstandards@darlington.gov.uk|
	|Hartlepool Borough Council|trading.standards@hartlepool.gov.uk|
	|Sunderland City Council|public.health@sunderland.gov.uk|
	|North Tyneside Council|trading.standards@northtyneside.gov.uk|
	|Durham County Council|tradingstandards@durham.gov.uk|
	|St Helens Metropolitan Borough Council|tradingstandards@sthelens.gov.uk|
	|Blackburn with Darwen Borough Council|publicprotection@blackburn.gov.uk|
	|Knowsley Metropolitan Borough Council|consumer.advice@knowsley.gov.uk|
	|Rochdale Metropolitan Borough Council|trading.standards@rochdale.gov.uk|
	|Trafford Metropolitan Borough Council|trading.standards@trafford.gov.uk|
	|Bolton Metropolitan Borough Council|trading.standards@bolton.gov.uk|
	|Oldham Metropolitan Borough Council|tradingstandards@oldham.gov.uk|
	|Sefton Metropolitan Borough Council|Seftonts@sefton.gov.uk|
	|Wigan Metropolitan Borough Council|ts@wigan.gov.uk|
	|Bury Metropolitan Borough Council|tradingstandards@bury.gov.uk|
	|Cheshire West and Chester Council||
	|Warrington Borough Council|tradingstandards@warrington.gov.uk|
	|Blackpool Borough Council|tradingstandards@blackpool.gov.uk|
	|Lancashire County Council|tsdo@lancashire.gov.uk|
	|Manchester City Council|trading_standards@manchester.gov.uk|
	|Cumbria County Council|trading.standards@cumbria.gov.uk|
	|Halton Borough Council|Trading.Standards@halton.gov.uk|
	|Liverpool City Council|enforcement@liverpool.gov.uk|
	|Wirral Borough Council|tradingstandards@wirral.gov.uk|
	|Cheshire East Council|tradingstandards@cheshireeast.gov.uk|
	|Salford City Council|trading.standards@salford.gov.uk|
	|Stockport Council|standards@stockport.gov.uk|
	|Tameside Council|tradingstandards@tameside.gov.uk|
	|Bournemouth, Christchurch and Poole Councils|trading.standards@bcpcouncil.gov.uk|
	|Bath and North East Somerset Council|public_protection@bathnes.gov.uk|
	|Devon, Somerset and Torbay Councils|tradingstandards@devon.gov.uk|
	|Gloucestershire County Council|tradingstandards@gloucestershire.gov.uk|
	|South Gloucestershire Council|trading.standards@southglos.gov.uk|
	|Wiltshire County Council|tradingstandards@wiltshire.gov.uk|
	|Cornwall County Council|businesscompliance@cornwall.gov.uk|
	|Swindon Borough Council|TSduty@Swindon.gov.uk|
	|North Somerset Council|trading.standards@n-somerset.gov.uk|
	|Dorset County Council|tradingstandards@dorsetcouncil.gov.uk|
	|Plymouth City Council|trading.standards@plymouth.gov.uk|
	|Bristol City Council|trading.standards@bristol.gov.uk|
	|Blaenau Gwent and Torfaen County Borough Council|trading.standards@blaenau-gwent.gov.uk|
	|Bridgend, Cardiff and the Vale of Glamorgan|adminsupport-srswales@valeofglamorgan.gov.uk|
	|Neath Port Talbot County Borough Council|tsd@npt.gov.uk|
	|Rhondda Cynon Taf County Borough Council|tradingstandards@rctcbc.gov.uk|
	|Merthyr Tydfil County Borough Council|tstandards@merthyr.gov.uk|
	|Caerphilly County Borough Council|tradingstandards@caerphilly.gov.uk|
	|Isle of Anglesey County Council|TradingStandards@ynysmon.gov.uk|
	|Swansea City and County Council|trading.standards@swansea.gov.uk|
	|Carmarthenshire County Council|tradingstandards@carmarthenshire.gov.uk|
	|Wrexham County Borough Council|tradstand@wrexham.gov.uk|
	|Conwy County Borough Council|trading.standards@conwy.gov.uk|
	|Monmouthshire County Council|tradingstandards@monmouthshire.gov.uk|
	|Pembrokeshire County Council|tradingstandards@pembrokeshire.gov.uk|
	|Denbighshire County Council|tradingstandards@denbighshire.gov.uk|
	|Ceredigion County Council|tradingstandards@ceredigion.gov.uk|
	|Flintshire County Council|trading.standards@flintshire.gov.uk|
	|Gwynedd County Council|safmas@gwynedd.llyw.cymru|
	|Newport City Council|trading.standards@newport.gov.uk|
	|Powys County Council|trading.standards@powys.gov.uk|
	|Sandwell Metropolitan Borough Council|Trading_Standards@sandwell.gov.uk|
	|Solihull Metropolitan Borough Council|tradingstandards@solihull.gov.uk|
	|Walsall Metropolitan Borough Council|tradingstandards@walsall.gov.uk|
	|Dudley Metropolitan Borough Council|ts.online@dudley.gov.uk|
	|Worcestershire County Council||
	|Staffordshire County Council|hqtsrecept@staffordshire.gov.uk|
	|Warwickshire county council|standards@warwickshire.gov.uk|
	|Wolverhampton City Council|trading.standards@wolverhampton.gov.uk|
	|Shropshire County Council|ts.enforcement@shropshire.gov.uk|
	|Telford & Wrekin Council|pp.support@telford.gov.uk|
	|Birmingham City Council|TradingStandards@birmingham.gov.uk|
	|City of Stoke on Trent|public.protection@stoke.gov.uk|
	|Coventry City Council|tradingstandards@coventry.gov.uk |
	|Walsall Metropolitan Borough Council|tradingstandards@walsall.gov.uk|

  @new-user
  Scenario Outline: Add team admin user in KC
    Given I login as keycloack Admin user
    When I go to users
    And I click add user
    And I enter username "<user-name>"
    And I click save
    Then I should be able to add to "<group-name>"
    And I select role as team_admin
    And I should be able to invite user
    Examples:
    |user-name				  |group-name|
    |psd-loadtest11@example.com|Trading Standards Southampton|
    |psd-loadtest12@example.com|Birmingham TS|
    |psd-loadtest13@example.com|Birmingham TS|
    |psd-loadtest14@example.com|Birmingham TS|
    |psd-loadtest15@example.com|Birmingham TS|
    |psd-loadtest16@example.com|Birmingham TS|
    |psd-loadtest17@example.com|Birmingham TS|
    |psd-loadtest18@example.com|Birmingham TS|
    |psd-loadtest19@example.com|Birmingham TS|
    |psd-loadtest20@example.com|Birmingham TS|
    |psd-loadtest21@example.com|Birmingham TS|
    |psd-loadtest22@example.com|Birmingham TS|
    |psd-loadtest23@example.com|Birmingham TS|
    |psd-loadtest24@example.com|Birmingham TS|
    |psd-loadtest25@example.com|Birmingham TS|
    |psd-loadtest26@example.com|Birmingham TS|
    |psd-loadtest27@example.com|Birmingham TS|
    |psd-loadtest28@example.com|Birmingham TS|
    |psd-loadtest29@example.com|Birmingham TS|
    |psd-loadtest30@example.com|Birmingham TS|
    
		