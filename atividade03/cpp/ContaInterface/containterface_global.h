#ifndef CONTAINTERFACE_GLOBAL_H
#define CONTAINTERFACE_GLOBAL_H

#include <QtCore/qglobal.h>

#if defined(CONTAINTERFACE_LIBRARY)
#  define CONTAINTERFACESHARED_EXPORT Q_DECL_EXPORT
#else
#  define CONTAINTERFACESHARED_EXPORT Q_DECL_IMPORT
#endif

#endif // CONTAINTERFACE_GLOBAL_H
