INSERT INTO `roles` (`ROL`) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (`ROL`) VALUES ('ROLE_MOVIL');
INSERT INTO `roles` (`ROL`) VALUES ('ROLE_QC');
INSERT INTO `roles` (`ROL`) VALUES ('ROLE_CATALOG');

INSERT INTO `centers` (`CS`) VALUES ('Socrates Flores');
INSERT INTO `centers` (`CS`) VALUES ('Edgard Lang');
INSERT INTO `centers` (`CS`) VALUES ('Francisco Buitrago');

INSERT INTO `users` (`NOMBRE_USUARIO`, `CUENTA_SINEXPIRAR`, `CUENTA_SINBLOQUEAR`, `DESCRIPCION`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`, `CREDENCIAL_SINEXPIRAR`, `CORREO_ELECTRONICO`, `HABILITADO`, `FECHA_ULTACC`, `FECHA_ULTMODCRED`, `FECHA_ULTMOD`, `USUARIO_ULTMOD`, `CONTRASENA`) VALUES ('admin', '', '', 'Administrador', '2014-09-20 08:31:00', 'admin', '', 'admincndr@minsa.gob.ni', '', '2014-11-16 10:05:40', NULL, '2014-11-13 17:58:06', 'admin', '6c36dc262b0e44be5811c2296669fc65643aec9dcaa4a76501e0a9508b633fd01ee59a207f8c6d68');
INSERT INTO `users_roles` (`ROL`, `NOMBRE_USUARIO`, `PASIVO`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`) VALUES ('ROLE_ADMIN', 'admin', '0', '2016-06-07 10:47:12', 'admin');
INSERT INTO `users_roles` (`ROL`, `NOMBRE_USUARIO`, `PASIVO`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`) VALUES ('ROLE_MOVIL', 'admin', '0', '2016-06-07 10:47:12', 'admin');
INSERT INTO `users_roles` (`ROL`, `NOMBRE_USUARIO`, `PASIVO`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`) VALUES ('ROLE_QC', 'admin', '0', '2016-06-07 10:47:12', 'admin');
/*Pagina denegado*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( '403.denied', 'Acceso denegado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( '403.deniedmessage', 'Lo sentimos','0');
/*Pagina no encontrado*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( '404.notfound', 'No encontrado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( '404.notfoundmessage', 'Lo sentimos','0');
/*Acciones, todas las paginas*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'actions', 'Acciones','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'add', 'Agregar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'save', 'Guardar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'edit', 'Editar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'cancel', 'Cancelar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'disable', 'Deshabilitar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'enable', 'Habilitar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'end', 'Finalizar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'unlock', 'Desbloquear','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'lock', 'Bloquear','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'export', 'Exportar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'ok', 'Aceptar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'search', 'Buscar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'confirm', 'Confirmar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'please.enter', 'Favor ingresar','0');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`, `en`) VALUES ('delete', '0', 'Eliminar', 'Delete');

/*Menu navegacion*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'home', 'Inicio','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'pregnants', 'Embarazadas','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'pregnantsdash', 'Panel de control','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ('diary', 'Agenda', '0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'admin', 'Administracion','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'adminusers', 'Usuarios','0');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('lbl.query', '0', 'Consulta');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('editdata', '0', 'Editar datos');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'profile', 'Perfil','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'changepass', 'Cambiar contrasena..','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'logout', 'Salir','0');
/*Mensajes generales, todas las paginas*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'enabled', 'Habilitado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'locked', 'Bloqueado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'form.errors', 'Tiene errores en su formulario. Favor verificar!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'process.errors', 'Han ocurrido errores en el proceso!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'process.success', 'El proceso se ha completado exitosamente!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'date', 'Fecha','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'not', 'Notificacion','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'notenabled', 'Deshabilitado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'notlocked', 'Desbloqueado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'seconds', 'segundos','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'session.expiring', 'Su sesion esta a punto de expirar!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'session.expiring.confirm', 'Quiere continuar con su sesion?','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'session.expiring.time', 'Su sesion se cerrara en','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'session.keep', 'Mantener sesion','0');
/*Metadata*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'createdBy', 'Creado por','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'dateCreated', 'Fecha creacion','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'modifiedBy', 'Modificado por','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'dateModified', 'Fecha de modificacion','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'active', 'Activo','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'addedBy', 'Agregado por','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'dateAdded', 'Fecha','0');

/*login*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login', 'Ingresar','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.accountExpired', 'Cuenta de usuario ha expirado!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.accountLocked', 'Cuenta de usuario esta bloqueada!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.accountNotLocked', 'Cuenta de usuario esta desbloqueada!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.badCredentials', 'Nombre de usuario o contrasena incorrectos!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.credentialsExpired', 'Credenciales de usuario han expirado!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.footer', 'Instituto de Ciencias Sostenibles','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.maxSessionsOut', 'Tiene una sesion activa! No puede crear otra!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.msg', 'Por favor ingresar su nombre de usuario y contrasena','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.page', 'Pagina de ingreso','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.password', 'Contrasena','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.userEnabled', 'Usuario esta activo!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.userDisabled', 'Usuario esta inactivo!','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'login.username', 'Nombre de usuario','0');
/*forzar cambio contrase�a*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'credentials.expired', 'Su contrasena ha caducado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'pass.updated', 'Su contrasena ha sido actualizada','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'password.repeat', 'Repita la contrasena','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'Pattern.password.format', 'Al menos 8 caracteres combinando mayusculas, minusculas, numeros y caracteres especiales','0');
/*Plantilla*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'heading', 'ESTUDIO DE TRANSMISION MATERNO-FETAL DEL VIRUS ZIKA Y SUS COMPLICACIONES','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'title', 'ZPO 2.0','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'footer', 'Instituto de Ciencias Sostenibles','0');
/*pagina principal*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'dashboard', 'Panel de control','0');
/*Usuarios*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'username', 'Usuario','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'userdesc', 'Descripcion','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'useremail', 'Correo','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'userlock', 'Bloqueado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'usercred', 'Contrasena vencida','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'userexp', 'Cuenta vencida','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'userroles', 'Roles','0');

/*Accesos*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'access', 'Accesos de usuario','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'lastAccess', 'Ultimo acceso','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'dateCredentials', 'Ultimo cambio de contrasena','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'session', 'Id de sesion','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'ipaddress', 'Direccion IP','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'logindate', 'Fecha ingreso','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'logoutdate', 'Fecha salida','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'logouturl', 'URL salida','0');
/*Audit trail*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'audittrail', 'Bitacora de cambios','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'entityClass', 'Clase','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'entityName', 'Nombre','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'entityProperty', 'Propiedad','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'entityPropertyOldValue', 'Valor anterior','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'entityPropertyNewValue', 'Nuevo valor','0');


/*Roles*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'ROLE_ADMIN', 'Administrador','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'ROLE_QC', 'Usuario web','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'ROLE_MOVIL', 'Usuario movil','0');

/*Catalogos*/
INSERT INTO `messages` (`messageKey`, `es`, `catKey`, `catPasive`) VALUES ( 'snd', 'Si, No, Desconocido',0,'0');
INSERT INTO `messages` (`messageKey`, `es`, `catKey`, `catPasive`) VALUES ( 'no', 'N',2,'0');
INSERT INTO `messages` (`messageKey`, `es`, `catKey`, `catPasive`) VALUES ( 'yes', 'S',1,'0');
INSERT INTO `messages` (`messageKey`, `es`, `catKey`, `catPasive`) VALUES ( 'unk', 'D',9,'0');


/*theme*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.blue', 'Azul','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.boxed', 'En caja','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.color', 'Color','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.dark', 'Negro','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.default', 'Movible','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.fixed', 'Fijo','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.fluid', 'Fuido','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.footer', 'Pie de pagina','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.grey', 'Gris','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.header', 'Encabezado','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.layout', 'Diseno','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.left', 'Izquierda','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.light', 'Claro','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.red', 'Rojo','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.right', 'Derecha','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.sbposition', 'Posicion Barra lateral','0');
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'theme.sidebar', 'Barra lateral','0');

/*exportar*/
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('download', '0', 'Descargar');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpo00', '0', 'Formulario Zpo Tamizaje');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('allforms', '0', 'Todos');
INSERT INTO `messages` (`messageKey`, `en`, `catPasive`, `es`) VALUES ('form', 'Form', '0', 'Formulario');
INSERT INTO `messages` (`messageKey`, `en`, `catPasive`, `es`) VALUES ('event', 'Event', '0', 'Evento');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('subjectId.start', '0', 'Codigo de Inicio');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('subjectId.end', '0', 'Codigo de Fin');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('screening_arm_1', '0', 'Tamizaje');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('entry_arm_1', '0', 'Ingreso');

/*query*/
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('consult', '0', 'Consultar');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('query.help', '0', 'Favor especifar cada columna en el SELECT, no usar *');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('run', '0', 'Ejecutar');
/*etiquetas comunes*/
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('lbl.select', '0', 'Seleccione');
/*entidades*/
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('class ni.org.ics.zpo.v2.domain.relationships.UserCenter', '0', 'Centro del usuario');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('class ni.org.ics.zpo.v2.users.model.UserSistema', '0', 'Usuario');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('class ni.org.ics.zpo.v2.users.model.Authority', '0', 'Rol del usuario');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('class ni.org.ics.zpo.v2.domain.catalogs.Provider', '0', 'Proveedor');
/*Agenda*/
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('subjectId', '0', 'Codigo Participante');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('diary.registerdate', '0', 'Fecha Ingreso');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('diary.event', '0', 'Semana Cita');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('diary.scheduleddate', '0', 'Fecha Programada');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('diary.agreeddate', '0', 'Fecha Cita');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('visits', '0', 'Visitas');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('diary.agreedtime', '0', 'Hora Cita');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('diary.programmingdate', '0', 'Fecha de programacion de cita');

/*dashboard*/
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week2', '0', 'Semana 2');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week4', '0', 'Semana 4');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week6', '0', 'Semana 6');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week8', '0', 'Semana 8');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week10', '0', 'Semana 10');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week12', '0', 'Semana 12');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week14', '0', 'Semana 14');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week16', '0', 'Semana 16');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week18', '0', 'Semana 18');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week20', '0', 'Semana 20');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week22', '0', 'Semana 22');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week24', '0', 'Semana 24');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week26', '0', 'Semana 26');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week28', '0', 'Semana 28');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week30', '0', 'Semana 30');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week32', '0', 'Semana 32');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week34', '0', 'Semana 34');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week36', '0', 'Semana 36');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week38', '0', 'Semana 38');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week40', '0', 'Semana 40');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week42', '0', 'Semana 42');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('week44', '0', 'Semana 44');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('entry', '0', 'Ingreso');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('delivery', '0', 'Parto');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('postdeli', '0', 'Postparto');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('detail', '0', 'Detalle');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('realized', '0', 'Realizado');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('pending', '0', 'Pendiente');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('status', '0', 'Estado');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('subjects', '0', 'Participantes');

//Dashboard panel principal
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('change.date.range', '0', 'Cambiar el rango de fecha del panel');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('applyLabel', '0', 'Aplicar');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('fromLabel', '0', 'Desde');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('toLabel', '0', 'Hasta');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('customRangeLabel', '0', 'Personalizado');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('Su', '0', 'Do');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('Mo', '0', 'Lu');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('Tu', '0', 'Ma');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('We', '0', 'Mi');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('Th', '0', 'Ju');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('Fr', '0', 'Vi');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('Sa', '0', 'Sa');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('january', '0', 'Enero');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('february', '0', 'Febrero');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('march', '0', 'Marzo');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('april', '0', 'Abril');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('may', '0', 'Mayo');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('june', '0', 'Junio');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('july', '0', 'Julio');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('august', '0', 'Agosto');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('september', '0', 'Septiembre');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('october', '0', 'Octubre');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('november', '0', 'Noviembre');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('december', '0', 'Diciembre');

INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('screenxday', '0', 'Tamizajes por dia');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('total', '0', 'Total');

/*INFANTE*/
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpoInfante', '0', 'Formulario Datos del Infante');

/*Editar datos de formularios*/
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('setnull', '0', 'Establecer como Null');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('editdata.help', '0', 'Para campos tipo fecha usar formato dd/mm/yyyy. Para campos fecha y hora usar formato dd/mm/yyyy HH:mm (24 horas)');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpoCR', '0', 'Recepcion de consentimientos');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpoCS', '0', 'Salida de consentimientos');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('us_event_screening', '0', 'Ingreso');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('us_event_tri2', '0', '2do Trimestre');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('us_event_tri3', '0', '3er Trimestre');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('us_event_unsched', '0', 'No programado');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('lbl.any', '0', 'Ninguno');

/*Catalogos*/
INSERT INTO `messages` (`messageKey`, `es`, `catPasive`) VALUES ( 'ROLE_CATALOG', 'Cat�logos','0');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('catalog', '0', 'Cat�logos');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('catalogcenter', '0', 'Unidad de Salud');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('centers', '0', 'Unidades de Salud');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('centerName', '0', 'Nombre Unidad de Salud');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('catalogsubjtype', '0', 'Tipo de agenda');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('subjtypes', '0', 'Tipos de agenda');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('subjtypeName', '0', 'Nombre Tipo de Agenda'); 
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('specialities', '0', 'Especialidades');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('speciality', '0', 'Especialidad');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('catalogspeciality', '0', 'Especialidades'); 
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('appointmentTypes', '0', 'Tipos de citas');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('appointmentType', '0', 'Tipo de cita');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('catalogapptype', '0', 'Tipos de citas'); 
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('catalogprovider', '0', 'Proveedores de salud');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('providers', '0', 'Proveedores');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('providername', '0', 'Nombre');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('providerus', '0', 'Unidad de salud');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('providersp', '0', 'Especialidad');
INSERT INTO `messages` (`messageKey`, `catKey`, `en`, `catPasive`, `es`) VALUES ('providerid', NULL, NULL, '0', 'Codigo Proveedor');
INSERT INTO `messages` (`messageKey`, `catKey`, `en`, `catPasive`, `es`) VALUES ('provider.enabled', NULL, NULL, '0', 'Proveedor habilitado');
INSERT INTO `messages` (`messageKey`, `catKey`, `en`, `catPasive`, `es`) VALUES ('provider.disabled', NULL, NULL, '0', 'Proveedor deshabilitado');

/*Nuevos formularios ZPO 2.0 */

INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_cuest_sa_mat', '0', 'Cuestionario Salud Materna');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_cuest_sa_mat_upd', '0', 'Actualización Cuestionario Salud Materna');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_cuest_socioe', '0', 'Cuestionario Socieconómico');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_biosp_coll', '0', 'Recolección de muestras materna/infante(s)');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_eval_psico', '0', 'Evaluación Psicológica');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_cuest_demo', '0', 'Cuestionario Demográfico');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_cuest_demo_upd', '0', 'Actualización Cuestionario Demográfico');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_cuest_sa_inf', '0', 'Cuestionario Salud Infantil');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_cuest_sa_inf_upd', '0', 'Actualizacion Cuestionario Salud Infantil');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_exam_fis_inf', '0', 'Examen Físico Infante');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_ind_cuidado_fam', '0', 'Encuesta Indicadores del Cuidado de la Familia');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_mullen', '0', 'Escala Mullen de Aprendizaje Temprano');

INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_edades_etapas', '0', 'Tamizaje de Edades y Etapas');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_eval_audi', '0', 'Evaluación Auditiva');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_eval_visual', '0', 'Evaluación Visual');
INSERT INTO `messages` (`messageKey`, `catPasive`, `es`) VALUES ('zpov2_study_exit', '0', 'Salida del Estudio');