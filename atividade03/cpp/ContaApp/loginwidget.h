#ifndef LOGINWIDGET_H
#define LOGINWIDGET_H

#include <QWidget>
#include <QFormLayout>
#include <QLineEdit>
#include <QPushButton>


class LoginWidget : public QWidget
{
    Q_OBJECT
public:
    explicit LoginWidget(QWidget *parent = 0);
    void init();

private:
    QFormLayout* m_formLayout;
    QLineEdit* m_agenciaLineEdit;
    QLineEdit* m_contaLineEdit;
    QLineEdit* m_senhaLineEdit;
    QPushButton* m_loginButton;
};

#endif // LOGINWIDGET_H
