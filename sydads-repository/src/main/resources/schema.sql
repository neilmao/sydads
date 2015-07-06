
    create table AdsPosition (
        id varchar(64) not null,
        Position int4,
        Price int4,
        primary key (id)
    )

    create table AdsUser (
        Class varchar(31) not null,
        id varchar(64) not null,
        BusinessName varchar(255),
        Email varchar(255),
        FirstName varchar(255),
        LastName varchar(255),
        Mobile varchar(255),
        Password varchar(255),
        RegisterDate date,
        Status int4,
        VerifyDate date,
        RemainedRewards float8,
        TotalRewards float8,
        Company varchar(255),
        Credit int4,
        PendingCredit int4,
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
        CurrentViews int4,
        EndDate date,
        RequiredViews int4,
        RewardsPerView float8,
        Status int4,
        Title varchar(255),
        UpdatedDate date,
        AuthorId varchar(64),
        primary key (id)
    )

    create table NewsContainedAdvertisement (
        NewsId varchar(64) not null,
        AdvertisementId varchar(64) not null,
        primary key (NewsId, AdvertisementId)
    )

    create table News_AdsUser (
        News_id varchar(64) not null,
        pushers_id varchar(64) not null,
        primary key (News_id, pushers_id)
    )

    create table PageView (
        id varchar(64) not null,
        Browser varchar(255),
        Ip varchar(255),
        Os varchar(255),
        Timestamp timestamp,
        Token varchar(255),
        TrackerId varchar(64),
        primary key (id)
    )

    create table Payment (
        Class varchar(31) not null,
        id varchar(64) not null,
        Amount float8,
        Date date,
        AdminId varchar(64),
        VendorId varchar(64),
        PusherId varchar(64),
        primary key (id)
    )

    create table Request (
        id varchar(64) not null,
        primary key (id)
    )

    create table Tracker (
        id varchar(64) not null,
        NoOfValidViews int4,
        NewsId varchar(64),
        PusherId varchar(64),
        primary key (id)
    )

    create table UserPushedNews (
        UserId varchar(64) not null,
        NewsId varchar(64) not null,
        primary key (UserId, NewsId)
    )

    create table User_roles (
        User_id varchar(64) not null,
        UserRole int4
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

    alter table NewsContainedAdvertisement 
        add constraint FK_o6xtp5vbia9ybgjw406b19ago 
        foreign key (AdvertisementId) 
        references Advertisement

    alter table NewsContainedAdvertisement 
        add constraint FK_50f5e8dnqp7nwxn9jwhpbecaf 
        foreign key (NewsId) 
        references News

    alter table News_AdsUser 
        add constraint FK_njh0vsb6rd2ndype08f31pj5t 
        foreign key (pushers_id) 
        references AdsUser

    alter table News_AdsUser 
        add constraint FK_rd05egm9qv0ogifer19qmdvx5 
        foreign key (News_id) 
        references News

    alter table PageView 
        add constraint FK_2wlq44n3c2n8hyr6swmqwtp8t 
        foreign key (TrackerId) 
        references Tracker

    alter table Payment 
        add constraint FK_f2qh7h2i8hoaddpfciddnf1mu 
        foreign key (AdminId) 
        references AdsUser

    alter table Payment 
        add constraint FK_t7htg4m36v5rucc2tidk9fgu4 
        foreign key (VendorId) 
        references AdsUser

    alter table Payment 
        add constraint FK_ki2yegs6man3esnbwsbwn3y8g 
        foreign key (PusherId) 
        references AdsUser

    alter table Tracker 
        add constraint FK_m3v1li0cbxc2mti0bwwe2c7ys 
        foreign key (NewsId) 
        references News

    alter table Tracker 
        add constraint FK_fmsgks9gneqmg4yfm1dyqsp2r 
        foreign key (PusherId) 
        references AdsUser

    alter table UserPushedNews 
        add constraint FK_81mmyuakfkc9na7aeghjx1die 
        foreign key (NewsId) 
        references News

    alter table UserPushedNews 
        add constraint FK_g1bbr2445xtaaenhufylj9gx4 
        foreign key (UserId) 
        references AdsUser

    alter table User_roles 
        add constraint FK_9npctppqlup1uag8ek04qpmie 
        foreign key (User_id) 
        references AdsUser
