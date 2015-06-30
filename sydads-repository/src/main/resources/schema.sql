
    create table AdsUser (
        id varchar(64) not null,
        Email varchar(255),
        FirstName varchar(255),
        LastName varchar(255),
        Mobile varchar(255),
        Password varchar(255),
        RegisterDate date,
        UserStatus int4,
        VerifyDate date,
        primary key (id)
    )

    create table Advertisement (
        id varchar(64) not null,
        Category int4,
        Content varchar(255),
        CreatedDate date,
        ExpiredDate date,
        Status int4,
        Title varchar(255),
        UpdatedDate date,
        VendorId varchar(64),
        primary key (id)
    )

    create table AttachedImage (
        id varchar(64) not null,
        FileName varchar(255),
        FileSize int8,
        AdvertisementId varchar(64),
        NewsId varchar(64),
        primary key (id)
    )

    create table News (
        id varchar(64) not null,
        Content varchar(255),
        CreatedDate date,
        Status int4,
        Title varchar(255),
        UpdatedDate date,
        AuthorId varchar(64),
        primary key (id)
    )

    create table Request (
        id varchar(64) not null,
        primary key (id)
    )

    create table Tracker (
        id varchar(64) not null,
        primary key (id)
    )

    create table UserPushedAdvertisement (
        UserId varchar(64) not null,
        AdvertisementId varchar(64) not null,
        primary key (UserId, AdvertisementId)
    )

    create table User_roles (
        User_id varchar(64) not null,
        UserRole varchar(255)
    )

    alter table Advertisement 
        add constraint FK_pqfj3gggepftxo2w97u53d1yv 
        foreign key (VendorId) 
        references AdsUser

    alter table AttachedImage 
        add constraint FK_tkc8rcoeuj7mtafmmb84eocy5 
        foreign key (AdvertisementId) 
        references Advertisement

    alter table AttachedImage 
        add constraint FK_599frbyec6326ud4k96jxe243 
        foreign key (NewsId) 
        references News

    alter table News 
        add constraint FK_5ofshkvqrrcfoo11p2f927oh4 
        foreign key (AuthorId) 
        references AdsUser

    alter table UserPushedAdvertisement 
        add constraint FK_o1muo98ki64nuugh97kwu3gt1 
        foreign key (AdvertisementId) 
        references Advertisement

    alter table UserPushedAdvertisement 
        add constraint FK_c9lsykkxgrxtrh611p095ndv9 
        foreign key (UserId) 
        references AdsUser

    alter table User_roles 
        add constraint FK_9npctppqlup1uag8ek04qpmie 
        foreign key (User_id) 
        references AdsUser
