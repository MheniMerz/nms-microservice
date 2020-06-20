package io.nms.central.microservice.topology.impl;

public class Sql {
	
	public static final String CREATE_TABLE_VSUBNET = "CREATE TABLE IF NOT EXISTS `Vsubnet` (\n" +
			"    `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"    `name` VARCHAR(30) NOT NULL UNIQUE,\n" + 
			"    `label` VARCHAR(60),\n" + 
			"    `description` VARCHAR(255),\n" +
			"	 `info` JSON DEFAULT NULL,\n" +
			"    `status` VARCHAR(10),\n" +
			"    `created` DATETIME DEFAULT CURRENT_TIMESTAMP,\n" + 
			"    `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" + 
			"    PRIMARY KEY (`id`)\n" + 			
			")";
	public static final String CREATE_TABLE_VNODE = "CREATE TABLE IF NOT EXISTS `Vnode` (\n" +
			"    `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"    `name` VARCHAR(30) NOT NULL UNIQUE,\n" + 
			"    `label` VARCHAR(60),\n" + 
			"    `description` VARCHAR(255),\n" +
			"	 `info` JSON DEFAULT NULL,\n" +
			"    `status` VARCHAR(10),\n" +
			"    `created` DATETIME DEFAULT CURRENT_TIMESTAMP,\n" + 
			"    `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" + 
			"    `posx` INT,\n" + 
			"    `posy` INT,\n" + 
			"    `location` VARCHAR(20),\n" + 
			"    `type` VARCHAR(10),\n" +
			"    `vsubnetId` INT NOT NULL,\n" + 
			"    PRIMARY KEY (`id`),\n" +
			"    FOREIGN KEY (`vsubnetId`)\n" + 
			"    	REFERENCES Vsubnet(`id`)\n" + 
			"       ON DELETE CASCADE\n" + 
			"		ON UPDATE CASCADE\n" + 
			")";
	public static final String CREATE_TABLE_VLTP = "CREATE TABLE IF NOT EXISTS Vltp (\n" +
			"    `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"    `name` VARCHAR(30) NOT NULL UNIQUE,\n" + 
			"    `label` VARCHAR(60),\n" + 
			"    `description` VARCHAR(255),\n" +
			"	 `info` JSON DEFAULT NULL,\n" +
			"    `status` VARCHAR(10),\n" +
			"    `created` DATETIME DEFAULT CURRENT_TIMESTAMP,\n" + 
			"    `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +  		
			"    `busy` BOOLEAN DEFAULT 0,\n" +
			"    `vnodeId` INT NOT NULL,\n" + 
			"    PRIMARY KEY (`id`),\n" + 
			"    FOREIGN KEY (`vnodeId`) \n" + 
			"        REFERENCES Vnode(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"		 ON UPDATE CASCADE\n" + 
			")";
	public static final String CREATE_TABLE_VCTP = "CREATE TABLE IF NOT EXISTS Vctp (\n" +
			"    `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"    `name` VARCHAR(30) NOT NULL UNIQUE,\n" + 
			"    `label` VARCHAR(60),\n" + 
			"    `description` VARCHAR(255),\n" +
			"	 `info` JSON DEFAULT NULL,\n" +
			"    `status` VARCHAR(10),\n" +
			"    `created` DATETIME DEFAULT CURRENT_TIMESTAMP,\n" + 
			"    `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" + 
			"    `vltpId` INT NOT NULL,\n" +  
			"    PRIMARY KEY (`id`),\n" + 
			"    FOREIGN KEY (`vltpId`) \n" + 
			"       REFERENCES Vltp(`id`)\n" + 
			"       ON DELETE CASCADE\n" + 
			"		ON UPDATE CASCADE\n" +
			")";
	public static final String CREATE_TABLE_VLINK = "CREATE TABLE IF NOT EXISTS Vlink (\n" +
			"    `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"    `name` VARCHAR(30) NOT NULL UNIQUE,\n" + 
			"    `label` VARCHAR(60),\n" + 
			"    `description` VARCHAR(255),\n" +
			"	 `info` JSON DEFAULT NULL,\n" +
			"    `status` VARCHAR(10),\n" +
			"    `created` DATETIME DEFAULT CURRENT_TIMESTAMP,\n" + 
			"    `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
			"    `type` VARCHAR(10),\n" + 
			"    `srcVltpId` INT NOT NULL,\n" + 
			"    `destVltpId` INT NOT NULL,\n" + 
			"    PRIMARY KEY (`id`),\n" + 
			"    UNIQUE (`name`),\n" +
			"    FOREIGN KEY (`srcVltpId`) \n" + 
			"        REFERENCES Vltp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE,\n" + 
			"    FOREIGN KEY (`destVltpId`) \n" + 
			"        REFERENCES Vltp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE\n" + 
			")";
	public static final String CREATE_TABLE_VLINKCONN = "CREATE TABLE IF NOT EXISTS VlinkConn (\n" +
			"    `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"    `name` VARCHAR(30) NOT NULL UNIQUE,\n" + 
			"    `label` VARCHAR(60),\n" + 
			"    `description` VARCHAR(255),\n" +
			"	 `info` JSON DEFAULT NULL,\n" +
			"    `status` VARCHAR(10),\n" +
			"    `created` DATETIME DEFAULT CURRENT_TIMESTAMP,\n" + 
			"    `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
			"    `srcVctpId` INT NOT NULL,\n" + 
			"    `destVctpId` INT NOT NULL,\n" +
			"    PRIMARY KEY (`id`),\n" + 
			"    UNIQUE (`name`),\n" +
			"    FOREIGN KEY (`srcVctpId`) \n" + 
			"        REFERENCES Vctp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE,\n" + 
			"    FOREIGN KEY (`destVctpId`) \n" + 
			"        REFERENCES Vctp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE\n" + 
			")";
	public static final String CREATE_TABLE_VTRAIL = "CREATE TABLE IF NOT EXISTS Vtrail (\n" +
			"    `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"    `name` VARCHAR(30) NOT NULL UNIQUE,\n" + 
			"    `label` VARCHAR(60),\n" + 
			"    `description` VARCHAR(255),\n" +
			"	 `info` JSON DEFAULT NULL,\n" +
			"    `status` VARCHAR(10),\n" +
			"    `created` DATETIME DEFAULT CURRENT_TIMESTAMP,\n" + 
			"    `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
			"    `srcVctpId` INT NOT NULL,\n" + 
			"    `destVctpId` INT NOT NULL,\n" +
			"    PRIMARY KEY (`id`),\n" + 
			"    UNIQUE (`name`),\n" +
			"    FOREIGN KEY (`srcVctpId`) \n" + 
			"        REFERENCES Vctp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE,\n" + 
			"    FOREIGN KEY (`destVctpId`) \n" + 
			"        REFERENCES Vctp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE\n" + 
			")";
	public static final String CREATE_TABLE_VXC = "CREATE TABLE IF NOT EXISTS Vxc (\n" +
			"    `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"    `name` VARCHAR(30) NOT NULL UNIQUE,\n" + 
			"    `label` VARCHAR(60),\n" + 
			"    `description` VARCHAR(255),\n" +
			"	 `info` JSON DEFAULT NULL,\n" +
			"    `status` VARCHAR(10),\n" +
			"    `created` DATETIME DEFAULT CURRENT_TIMESTAMP,\n" + 
			"    `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
			"    `type` VARCHAR(10),\n" +  
			"    `vnodeId` INT NOT NULL,\n" +
			"    `vtrailId` INT NOT NULL,\n" +
			"    `srcVctpId` INT NOT NULL,\n" + 
			"    `destVctpId` INT NOT NULL,\n" +
			"    `dropVctpId` INT NOT NULL,\n" +
			"    PRIMARY KEY (`id`),\n" + 
			"    UNIQUE (`name`),\n" +
			"    FOREIGN KEY (`vnodeId`) \n" + 
			"        REFERENCES Vnode(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE,\n" +
			"    FOREIGN KEY (`vtrailId`) \n" + 
			"        REFERENCES Vtrail(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE,\n" + 
			"    FOREIGN KEY (`srcVctpId`) \n" + 
			"        REFERENCES Vctp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE\n" + 
			"    FOREIGN KEY (`destVctpId`) \n" + 
			"        REFERENCES Vctp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE,\n" + 
			"    FOREIGN KEY (`dropVctpId`) \n" + 
			"        REFERENCES Vctp(`id`)\n" + 
			"        ON DELETE CASCADE\n" + 
			"        ON UPDATE CASCADE\n" + 
			")";
	
	public static final String INSERT_VSUBNET = "INSERT INTO Vsubnet (name, label, description, info, status) "
			+ "VALUES (?, ?, ?, ?, ?)";
	public static final String INSERT_VNODE = "INSERT INTO Vnode (name, label, description, info, status, posx, posy, location, type, vsubnetId) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_VLTP = "INSERT INTO Vltp (name, label, description, info, status, busy, vnodeId) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_VCTP = "INSERT INTO Vctp (name, label, description, info, status, vltpId) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	public static final String INSERT_VLINK = "INSERT INTO Vlink (name, label, description, info, status, type, srcVltpId, destVltpId) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_VLINKCONN = "INSERT INTO VlinkConn (name, label, description, info, status, srcVctpId, destVctpId) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_VTRAIL = "INSERT INTO Vtrail (name, label, description, info, status, srcVctpId, destVctpId) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_VXC = "INSERT INTO Vxc (name, label, description, info, status, type, vnodeId, vtrailId, srcVctpId, destVctpId, dropVctpId) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	
	/*---------------------------------------*/
	public static final String FETCH_VSUBNET_BY_ID = "SELECT "
			+ "id, name, label, description, info, status, created, updated FROM Vsubnet "
			+ "WHERE id = ?";
	 
	public static final String FETCH_VNODE_BY_ID = "SELECT "
			+ "Vnode.id, Vnode.name, Vnode.label, Vnode.description, Vnode.info, Vnode.status, Vnode.created, Vnode.updated, "
			+ "Vnode.posx, Vnode.posy, Vnode.location, Vnode.type, Vnode.vsubnetId "
			+ "Vltp.id AS vltpId, Vltp.name AS VltpName, Vltp.label AS vltpLabel, Vltp.description AS vltpDescription, Vltp.info AS vltpInfo, "
			+ "Vltp.status AS vltpStatus, Vltp.created AS vltpCreated, Vltp.updated AS vltpUpdated, "
			+ "Vltp.busy AS vltpBusy, Vltp.vnodeId AS vltpVnodeId "
			+ "FROM `Vnode` LEFT JOIN `Vltp` ON Vnode.id=Vltp.vnodeId WHERE Vnode.id = ? GROUP BY Vnode.id";
	
	public static final String FETCH_VLTP_BY_ID = "SELECT "
			+ "Vltp.id, Vltp.name, Vltp.label, Vltp.description, Vltp.info, Vltp.status, Vltp.created, Vltp.updated, Vltp.busy, Vltp.vnodeId, "
			+ "Vctp.id AS vctpId, Vctp.name AS vctpName, Vctp.label AS vctpLabel, Vctp.description AS vctpDescription, "
			+ "Vctp.info AS vctpInfo, Vctp.status AS vctpStatus, Vctp.created AS vctpCreated, Vctp.updated AS vctpUpdated"
			+ "Vctp.vltpId AS vctpVltpId, "
			+ "FROM `Vltp` LEFT JOIN `Vctp` ON Vltp.id=Vctp.vltpId WHERE Vltp.id = ? GROUP BY Vltp.id";
	
	public static final String FETCH_VCTP_BY_ID = "SELECT "
			+ "id, name, label, description, info, status, created, updated, vltpId "
			+ "FROM Vctp WHERE id = ?";
	
	public static final String FETCH_VLINK_BY_ID = "SELECT "
			+ "Vlink.id, Vlink.name, Vlink.label, Vlink.description, Vlink.info, Vlink.status, Vlink.created, Vlink.updated, "
			+ "Vlink.type, Vlink.srcVltpId, Vlink.destVltpId, "
			+ "sLtp.vnodeId AS srcVnodeId, dLtp.vnodeId AS destVnodeId, "
			+ "sLtp.id AS srcVltpId, dLtp.id AS destVltpId, "
			+ "vlc.id AS vlcId, vlc.name AS vlcName, vlc.label AS vlcLabel, vlc.description AS vlcDescription, vlc.info AS vlcInfo, "
			+ "vlc.status AS vlcStatus, vlc.created AS vlcCreated, vlc.updated AS vlcUpdated, "
			+ "vlc.srcVctpId AS vlcSrcVctpId, vlc.destVctpId AS vlcDestVctpId, "
			+ "FROM (((Vlink "
			+ "INNER JOIN Vltp AS sLtp ON Vlink.srcVltpId=sLtp.id) "
			+ "INNER JOIN Vltp AS dLtp ON Vlink.destVltpId=dLtp.id) "
			+ "LEFT JOIN Vctp AS allVctps ON sLtp.id=Vctp.vltpId OR dLtp.id=Vctp.vltpId "
			+ "LEFT JOIN VlinkConn as vlc ON allVctps.id=vlc.srcVctpId OR allVctps.id=vlc.destVctpId) "
			+ "WHERE Vlink.id = ? GROUP BY vlcId";
	
	public static final String FETCH_VLINKCONN_BY_ID = "SELECT "
			+ "id, name, label, description, info, status, created, updated, srcVctpId, destVctpId,"
			+ "Vlink.id AS vlinkId, "
			+ "FROM ((VlinkConn "
			+ "INNER JOIN Vctp ON Vctp.id=srcVctpId INNER JOIN Vltp AS sLtp ON Vltp.id=Vctp.vltpId) "
			+ "INNER JOIN Vctp ON Vctp.id=destVctpId INNER JOIN Vltp AS dLtp ON Vltp.id=Vctp.vltpId) "
			+ "LEFT JOIN Vlink ON Vlink.srcVltpId=sLtp.id OR Vlink.destVltpId=dLtp.id"
			+ "WHERE id = ?";
	
	public static final String FETCH_VTRAIL_BY_ID = "SELECT "
			+ "Vtrail.id, Vtrail.name, Vtrail.label, Vtrail.description, Vtrail.info, Vtrail.status, Vtrail.created, Vtrail.updated, "
			+ "Vtrail.srcVctpId, Vtrail.destVctpId, "
			+ "Vxc.id AS vxcId, Vxc.name AS vxcName, Vxc.label AS vxcLabel, Vxc.description AS vxcDescription, Vxc.info AS vxcInfo, "
			+ "Vxc.status AS vxcStatus, Vxc.created AS vxcCreated, Vxc.updated AS vxcUpdated, "
			+ "Vxc.type AS vxcType, Vxc.vtrailId AS vxcVtrailId, Vxc.srcVctpId AS vxcSrcVctpId, Vxc.destVctpId AS vxcDestVctpId, Vxc.dropVctpId AS vxcDropVctpId "
			+ "FROM Vtrail LEFT JOIN Vxc ON Vtrail.id=Vxc.vtrailId"
			+ "WHERE id = ? GROUP BY Vxc.id";
	
	public static final String FETCH_VXC_BY_ID = "SELECT "
			+ "id, name, label, description, info, status, created, updated, type, vnodeId, vtrailId, srcVctpId, destVctpId, dropVctpId "
			+ "FROM Vxc WHERE id = ?"; 
	
	
	
	/*---------------------------------------*/
	public static final String FETCH_ALL_VSUBNETS = "SELECT "
			+ "id, name, label, description, info, status, created, updated "
			+ "FROM Vsubnet";
	 
	public static final String FETCH_ALL_VNODES = "SELECT "
			+ "id, name, label, description, info, status, created, updated, posx, posy, location, type, vsubnetId "
			+ "FROM Vnode";
	
	public static final String FETCH_ALL_VLTPS = "SELECT "
			+ "id, name, label, description, info, status, created, updated, busy, vnodeId "
			+ "FROM Vltp";
	
	public static final String FETCH_ALL_VCTPS = "SELECT "
			+ "id, name, label, description, info, status, created, updated, vltpId "
			+ "FROM Vctp"; 
  
	public static final String FETCH_ALL_VLINKS = "SELECT "
			+ "Vlink.id, Vlink.name, Vlink.label, Vlink.description, Vlink.info, Vlink.status, Vlink.created, Vlink.updated, "
			+ "Vlink.type, Vlink.srcVltpId, Vlink.destVltpId, "
			+ "s.vnodeId AS srcVnodeId, d.vnodeId AS destVnodeId "
			+ "FROM ((Vlink INNER JOIN Vltp AS s ON Vlink.srcVltpId=s.id) INNER JOIN Vltp AS d ON Vlink.destVltpId=d.id)";
	
	public static final String FETCH_ALL_VLINKCONNS = "SELECT "
			+ "id, name, label, description, info, status, created, updated, srcVctpId, destVctpId "
			+ "s.vltpId AS srcVltpId, d.vltpId AS destVltpId "
			+ "FROM ((VlinkConn INNER JOIN Vctp AS s ON VlinkConn.srcVctpId=s.id) INNER JOIN Vctp AS d ON VlinkConn.destVctpId=d.id)";

	public static final String FETCH_ALL_VTRAILS = "SELECT "
			+ "id, name, label, description, info, status, created, updated, srcVctpId, destVctpId "
			+ "FROM Vtrail"; 
	
	public static final String FETCH_ALL_VXCS = "SELECT "
			+ "id, name, label, description, info, status, created, updated, type, vnodeId, vtrailId, srcVctpId, destVctpId, dropVctpId "
			+ "FROM Vxc"; 
	
	/*---------------------------------------*/
	
	public static final String FETCH_VNODES_BY_VSUBNET = "SELECT "
			+ "id, name, label, description, info, status, created, updated, posx, posy, location, type, managed, vsubnetId "
			+ "FROM Vnode WHERE vsubnetId = ?";
			
	public static final String FETCH_VLINKS_BY_VSUBNET = " SELECT "
			+ "Vlink.id, Vlink.name, Vlink.label, Vlink.description, Vlink.info, Vlink.status, Vlink.created, Vlink.updated, "
			+ "Vlink.type, Vlink.srcVltpId, Vlink.destVltpId, " 
			+ "s.vnodeId AS srcVnodeId, d.vnodeId AS destVnodeId, "
			+ "Vnode.vsubnetId " 
			+ "FROM ((Vlink "
			+ "INNER JOIN Vltp AS s ON Vlink.srcVltpId=s.id) "
			+ "INNER JOIN Vltp AS d ON Vlink.destVltpId=d.id ) "
			+ "INNER JOIN Vnode ON Vnode.id=s.vnodeId OR Vnode.id=d.vnodeId "
			+ "WHERE Vnode.vsubnetId=? GROUP BY Vlink.id";
	
	public static final String FETCH_VLTPS_BY_VNODE = "SELECT "
			+ "id, name, label, description, info, status, created, updated, busy, vnodeId "
			+ "FROM Vltp WHERE vnodeId = ?";
	
	public static final String FETCH_VCTPS_BY_VLTP = "SELECT "
			+ "id, name, label, description, info, status, created, updated, vltpId "
			+ "FROM Vctp WHERE vltpId = ?";
	
	public static final String FETCH_VLINKCONNS_BY_VLINK = " SELECT "
			+ "VlinkConn.id, VlinkConn.name, VlinkConn.label, VlinkConn.description, VlinkConn.info, VlinkConn.status, VlinkConn.created, VlinkConn.updated, "
			+ "VlinkConn.srcVctpId, VlinkConn.destVctpId "
			+ "sLtp.id AS srcVltpId, dLtp.id AS destVltpId, Vlink.id as vlinkId " 
			+ "FROM ((VlinkConn "
			+ "INNER JOIN Vctp AS sCtp ON VlinkConn.srcVctpId=sCtp.id INNER JOIN Vltp as sLtp ON sCtp.vltpId=sLtp.id) "
			+ "INNER JOIN Vctp AS dCtp ON VlinkConn.destVctpId=dCtp.id INNER JOIN Vltp as dLtp ON dCtp.vltpId=dLtp.id)) "
			+ "INNER JOIN Vlink ON (Vlink.srcVltpId=sLtp.id AND Vlink.destVltpId=dLtp.id) OR (Vlink.srcVltpId=dLtp.id AND Vlink.destVltpId=sLtp.id) "
			+ "WHERE Vlink.id=? GROUP BY VlinkConn.id";
	
	public static final String FETCH_VXC_BY_VNODE = "SELECT "
			+ "id, name, label, description, info, status, created, updated, type, vnodeId, vtrailId, srcVctpId, destVctpId, dropVctpId "
			+ "FROM Vxc WHERE vnodeId = ?";
	
	public static final String FETCH_VXC_BY_VTRAIL = "SELECT "
			+ "id, name, label, description, info, status, created, updated, type, vnodeId, vtrailId, srcVctpId, destVctpId, dropVctpId "
			+ "FROM Vxc WHERE vtrailId = ?";
	
	/*---------------------------------------*/
	
	public static final String DELETE_VSUBNET = "DELETE FROM Vsubnet WHERE id=?";
	public static final String DELETE_VNODE = "DELETE FROM Vnode WHERE id=?";
	public static final String DELETE_VLTP = "DELETE FROM Vltp WHERE id=?";
	public static final String DELETE_VCTP = "DELETE FROM Vctp WHERE id=?";
	public static final String DELETE_VLINK = "DELETE FROM Vlink WHERE id=?";
	public static final String DELETE_VLINKCONN = "DELETE FROM VlinkConn WHERE id=?";
	public static final String DELETE_VTRAIL = "DELETE FROM Vtrail WHERE id=?";
	public static final String DELETE_VXC = "DELETE FROM Vxc WHERE id=?";

}
