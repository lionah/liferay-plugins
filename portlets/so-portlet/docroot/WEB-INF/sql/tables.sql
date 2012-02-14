create table SO_FavoriteSite (
	userId LONG not null,
	groupId LONG not null,
	companyId LONG,
	primary key (userId, groupId)
);

create table SO_FavoriteSitesEntry (
	userId LONG not null,
	groupId LONG not null,
	companyId LONG,
	name VARCHAR(75) null,
	primary key (userId, groupId)
);

create table SO_MemberRequest (
	memberRequestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	key_ VARCHAR(75) null,
	receiverUserId LONG,
	invitedRoleId LONG,
	invitedTeamId LONG,
	status INTEGER
);

create table SO_ProjectsEntry (
	projectsEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description STRING null,
	startDate DATE null,
	endDate DATE null,
	data_ VARCHAR(1000) null
);