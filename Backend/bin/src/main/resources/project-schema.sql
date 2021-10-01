drop table if exists citizen CASCADE;
create table citizen 
(
	citizenID  string,
	forenames string,
	homeAddress string,
	dateOfBirth string,
	sex string
	
);

create table MainDTO 
(
	CitizenID string,
	AssociatesDTO set,
	WhereaboutsDTO set,
	VehicleDTO set,
	PeopleMobileDTO set,
	CitizenReturnDTO set,
	PeopleBankAccountDTO set
	
);