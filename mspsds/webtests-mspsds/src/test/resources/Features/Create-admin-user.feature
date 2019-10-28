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
    |user-name				  |group-name										|
    |rob.harvey@merton.gov.uk|Richmond, Merton and Wandsworth Borough|
		|douglas.dickson@rbkc.gov.uk|Royal Borough of Kensington and Chelsea|
		|Iain.bailey@kingston.gov.uk|Royal Borough of Kingston upon Thames|
		|Amanda.Butler@walthamforest.gov.uk|London Borough of Waltham Forest|
		|Katalin.Morath@towerhamlets.gov.uk|London Borough of Tower Hamlets|
		|Cenred.Elworthy@lbbd.gov.uk|Barking and Dagenham Borough|
		|martin.o'brien@lbhf.gov.uk|Hammersmith & Fulham Borough|
		|kcheung@hillingdon.gov.uk|London Borough of Hillingdon|
		|Sonita.Singh@islington.gov.uk|London Borough of Islington|
		|Ian.Tucker@redbridge.gov.uk|London Borough of Redbridge|
		|hedley.setahul@southwark.gov.uk|London Borough of Southwark|
		|georgia.forde@haringey.gov.uk|London Borough of Haringey|
		|josile.munro@havering.gov.uk|London Borough of Havering|
		|karmveer.johal@hounslow.gov.uk|London Borough of Hounslow|
		|Nicholas.Stabeler@lewisham.gov.uk|London Borough of Lewisham|
		|alex.brander@royalgreenwich.gov.uk|Royal Borough of Greenwich|
		|Matthew.Smith@bromley.gov.uk|London Borough of Bromley|
		|caroline.dawson@croydon.gov.uk|London Borough of Croydon|
		|Amanda.Butler@enfield.gov.uk|London Borough of Enfield|
		|eshe.deodat-hill@hackney.gov.uk|London Borough of Hackney|
		|Molumese@lambeth.gov.uk|London Borough of Lambeth|
		|Emma.Phasey@barnet.gov.uk|London Borough of Barnet|
		|Simon.Ellis@bexley.gov.uk|London Borough of Bexley|
		|martin.harland@camden.gov.uk|London Borough of Camden|
		|GlendinningW@ealing.gov.uk|London Borough of Ealing|
		|meredith.howell-morris@newham.gov.uk|London Borough of Newham|
		|sarah.littell@sutton.gov.uk|London Borough of Sutton|
		|Paul.lee@brent.gov.uk|London Borough of Brent|
		|lolder@westminster.gov.uk|City of Westminster|
		|Ian.Dobson@cityoflondon.gov.uk|City of London|
		|Judith.Shewan@southtyneside.gov.uk|South Tyneside Metropolitan Borough Council|
		|TraceyJohnson@Gateshead.Gov.UK|Gateshead Metropolitan Borough Council|
		|Julian.Sorrell@redcar-cleveland.gov.uk|Redcar & Cleveland Borough Council|
		|Jimmy.Jones@stockton.gov.uk|Stockton-on-Tees Borough Council|
		|david.c.ellerington@newcastle.gov.uk|Newcastle upon Tyne City Council|
		|darin.wilson@northumberland.gov.uk|Northumberland County Council|
		|Darren_hull@middlesbrough.gov.uk|Middlesbrough Borough Council|
		|Dawn.Taylor@darlington.gov.uk|Darlington Borough Council|
		|rachael.readman@hartlepool.gov.uk|Hartlepool Borough Council|
		|Andrew.Stephenson@sunderland.gov.uk|Sunderland City Council|
		|dave.hedley@northtyneside.gov.uk|North Tyneside Council|
		|craig.hudson@durham.gov.uk|Durham County Council|
		|michaelreed@sthelens.gov.uk|St Helens Metropolitan Borough Council|
		|Jason.O'Rourke@blackburn.gov.uk|Blackburn with Darwen Borough Council|
		|craig.ashton@knowsley.gov.uk|Knowsley Metropolitan Borough Council|
		|peter.gallagher@rochdale.gov.uk|Rochdale Metropolitan Borough Council|
		|kevin.welch@trafford.gov.uk|Trafford Metropolitan Borough Council|
		|melissa.shine@bolton.gov.uk|Bolton Metropolitan Borough Council|
		|michaela.monk@oldham.gov.uk|Oldham Metropolitan Borough Council|
		|sean.jones@sefton.gov.uk|Sefton Metropolitan Borough Council|
		|a.bari@wigan.gov.uk|Wigan Metropolitan Borough Council|
		|j.h.garland@bury.gov.uk|Bury Metropolitan Borough Council|
		|genevieve.jenkins@cheshirewestandchester.gov.uk|Cheshire West and Chester Council|
		|khales@warrington.gov.uk|Warrington Borough Council|
		|shaun.mckinney@blackpool.gov.uk|Blackpool Borough Council|
		|steven.brimble@lancashire.gov.uk|Lancashire County Council|
		|h.raw@manchester.gov.uk|Manchester City Council|
		|jonathan.west@cumbria.gov.uk|Cumbria County Council|
		|Chris.Ramsay@halton.gov.uk|Halton Borough Council|
		|daniel.blowes@liverpool.gov.uk|Liverpool City Council|
		|nickchesters@wirral.gov.uk|Wirral Borough Council|
		|jane.longley@cheshireeast.gov.uk|Cheshire East Council|
		|esther.forbes@salford.gov.uk|Salford City Council|
		|jo.wilson@stockport.gov.uk|Stockport Council|
		|carl.jones@tameside.gov.uk|Tameside Council|
		|andrew.crossen-white@bcpcouncil.gov.uk|Bournemouth, Christchurch and Poole Councils|
		|Kirsty_Langford@BATHNES.GOV.UK|Bath and North East Somerset Council|
		|vanessa.daniel@devon.gov.uk|Devon, Somerset and Torbay Councils|
		|Sarah.WATSON@gloucestershire.gov.uk|Gloucestershire County Council|
		|charlotte.allard@southglos.gov.uk|South Gloucestershire Council|
		|Thomas.Hutchinson@wiltshire.gov.uk|Wiltshire County Council|
		|Gavin.Hill@cornwall.gov.uk|Cornwall County Council|
		|bdowning@swindon.gov.uk|Swindon Borough Council|
		|Debbie.Williams@n-somerset.gov.uk|North Somerset Council|
		|richard.herringshaw@dorsetcouncil.gov.uk|Dorset County Council|
		|Melanie.Walker@plymouth.gov.uk|Plymouth City Council|
		|Sarah.davey@bristol.gov.uk|Bristol City Council|
		|sion.thomas@blaenau-gwent.gov.uk|Blaenau Gwent and Torfaen County Borough Council|
		|jhotchkiss@valeofglamorgan.gov.uk|Bridgend, Cardiff and the Vale of Glamorgan|
		|s.burton@npt.gov.uk|Neath Port Talbot County Borough Council|
		|darran.h.davies@rctcbc.gov.uk|Rhondda Cynon Taf County Borough Council|
		|craig.rushton@merthyr.gov.uk|Merthyr Tydfil County Borough Council|
		|willibr@caerphilly.gov.uk|Caerphilly County Borough Council|
		|EmmaJones@ynysmon.gov.uk|Isle of Anglesey County Council|
		|rhys.harries@swansea.gov.uk|Swansea City and County Council|
		|aledthomas@carmarthenshire.gov.uk|Carmarthenshire County Council|
		|William.jones@wrexham.gov.uk|Wrexham County Borough Council|
		|Dawn.Bamford@conwy.gov.uk|Conwy County Borough Council|
		|KeithGardner@monmouthshire.gov.uk|Monmouthshire County Council|
		|jenny.tree@pembrokeshire.gov.uk|Pembrokeshire County Council|
		|tracey.heywood@denbighshire.gov.uk|Denbighshire County Council|
		|Lawrence.Martin@ceredigion.gov.uk|Ceredigion County Council|
		|margaret.rowlands@flintshire.gov.uk|Flintshire County Council|
		|endaflloydwilliams@gwynedd.llyw.cymru|Gwynedd County Council|
		|Alan.buckley@newport.gov.uk|Newport City Council|
		|jacqui.thomas@powys.gov.uk|Powys County Council|
		|samantha_parish@sandwell.gov.uk|Sandwell Metropolitan Borough Council|
		|gbrown@solihull.gov.uk |Solihull Metropolitan Borough Council|
		|amanda.ross@walsall.gov.uk |Walsall Metropolitan Borough Council|
		|Marion.wilson@dudley.gov.uk|Dudley Metropolitan Borough Council|
		|peter.holmes@worcestershirets.gov.uk|Worcestershire County Council|
		|tony.pugh@staffordshire.gov.uk|Staffordshire County Council|
		|ianferry@warwickshire.gov.uk|Warwickshire county council|
		|susan.bellingham@wolverhampton.gov.uk|Wolverhampton City Council|
		|sally.jones@shropshire.gov.uk |Shropshire County Council|
		|Alex.Rankin@telford.gov.uk |Telford & Wrekin Council|
		|Vir.Ahluwalia@birmingham.gov.uk|Birmingham City Council|
		|sarah.noonan@stoke.gov.uk|City of Stoke on Trent|
		|Alan.Harwood@coventry.gov.uk|Coventry City Council|
		|Lynda.Purcell@walsall.gov.uk|Walsall Metropolitan Borough Council|
    |testuser52@test.com|Southampton Council					|